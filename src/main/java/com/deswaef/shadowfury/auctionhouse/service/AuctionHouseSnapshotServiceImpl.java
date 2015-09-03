package com.deswaef.shadowfury.auctionhouse.service;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.auctionhouse.importing.AuctionHouseSnapshotImporter;
import com.deswaef.shadowfury.auctionhouse.repository.AuctionHouseSnapshotRepository;
import com.deswaef.shadowfury.auctionhouse.repository.AuctionHouseStatisticRepository;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rx.Observable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuctionHouseSnapshotServiceImpl implements AuctionHouseSnapshotService {

    @Autowired
    private AuctionHouseSnapshotRepository auctionHouseSnapshotRepository;
    @Autowired
    private AuctionHouseSnapshotImporter auctionHouseSnapshotImporter;
    @Autowired
    private AuctionHouseStatisticRepository auctionHouseStatisticRepository;

    @Override
    public List<AuctionHouseSnapshot> findByRealm(Realm realm) {
        return auctionHouseSnapshotRepository.readAllByRealm(realm.getId());
    }

    @Override
    public Long countByRealm(Realm realm) {
        return auctionHouseSnapshotRepository.countByRealm(realm.getId());
    }

    @Override
    public Observable<ServerMessage> doImport(Realm realm) {
        return Observable.<ServerMessage>create(s -> {
            if (auctionHouseStatisticRepository
                    .countByRealmAndExportTime(realm.getId(), LocalDate.now()
                            .format(DateTimeFormatter.ISO_LOCAL_DATE)) > 0) {
                s.onNext(ServerMessage.Builder
                        .create()
                        .failure()
                        .withMessage("Realm: " + realm.getLocality() + "-" + realm.getName() + " has already been imported today!")
                        .build()
                );
            } else {
                ServerMessage serverMessage = auctionHouseSnapshotImporter.importAuctionHouseSnapshots(realm);
                s.onNext(serverMessage);
            }
            s.onCompleted();
        });
    }

    @Override
    @Transactional
    public void deleteByRealm(Realm realm) {
        auctionHouseSnapshotRepository.deleteByRealm(realm.getId());
    }

    @Override
    @Transactional
    public void create(Iterable<AuctionHouseSnapshot> snapshots) {
        auctionHouseSnapshotRepository.save(snapshots);
    }

}

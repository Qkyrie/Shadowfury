package com.deswaef.shadowfury.auctionhouse.service;


import com.deswaef.shadowfury.auctionhouse.converting.AuctionHouseSnapshotToStatisticConverter;
import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseStatistic;
import com.deswaef.shadowfury.auctionhouse.repository.AuctionHouseSnapshotRepository;
import com.deswaef.shadowfury.auctionhouse.repository.AuctionHouseStatisticRepository;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rx.Observable;

import java.util.List;

import static com.deswaef.shadowfury.servermessage.domain.ServerMessage.Builder.create;

@Service
@Transactional(readOnly = true)
public class AuctionHouseStatisticServiceImpl implements AuctionHouseStatisticService {

    @Autowired
    private AuctionHouseSnapshotToStatisticConverter auctionHouseSnapshotToStatisticConverter;
    @Autowired
    private AuctionHouseSnapshotRepository auctionHouseSnapshotRepository;
    @Autowired
    private AuctionHouseStatisticRepository auctionHouseStatisticRepository;

    @Transactional
    @Override
    public Observable<ServerMessage> statify(Realm realm) {
        System.out.println("");
        return Observable.<ServerMessage>create(s -> {
            List<AuctionHouseSnapshot> auctionHouseSnapshots = auctionHouseSnapshotRepository.readAllByRealm(realm.getId());
            if (auctionHouseSnapshots.isEmpty()) {
                s.onNext(create()
                                .withMessage("Couldn't create statistics. There were no statistics for that realm")
                                .failure()
                                .build()
                );
            } else {
                try {
                    List<AuctionHouseStatistic> convertedStatistics = auctionHouseSnapshotToStatisticConverter.convert(realm.getId(), auctionHouseSnapshots);
                    auctionHouseStatisticRepository.save(convertedStatistics);
                    auctionHouseSnapshotRepository.deleteByRealm(realm.getId());
                    s.onNext(create()
                            .withMessage("created statistics for realm: " + realm.getLocality().getLocalityName() + "-" + realm.getName())
                            .success()
                            .build());
                } catch (Exception ex) {
                    s.onNext(create()
                            .withMessage("Couldn't create statistics. Something went wrong, please check the logs for realm " + realm.getLocality().getLocalityName() + "-" + realm.getName())
                            .failure()
                            .build());
                }
            }
            s.onCompleted();
        });
    }

}

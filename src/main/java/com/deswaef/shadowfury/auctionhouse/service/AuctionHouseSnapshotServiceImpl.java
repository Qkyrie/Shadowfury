package com.deswaef.shadowfury.auctionhouse.service;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.auctionhouse.repository.AuctionHouseSnapshotRepository;
import com.deswaef.shadowfury.realm.domain.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuctionHouseSnapshotServiceImpl implements AuctionHouseSnapshotService {

    @Autowired
    private AuctionHouseSnapshotRepository auctionHouseSnapshotRepository;

    @Override
    public List<AuctionHouseSnapshot> findByRealm(Realm realm) {
        return auctionHouseSnapshotRepository.findByRealm(realm.getId());
    }

    @Override
    public void deleteByRealm(Realm realm) {
        auctionHouseSnapshotRepository.delete(
                findByRealm(realm)
        );
    }

}

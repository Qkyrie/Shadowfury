package com.deswaef.shadowfury.auctionhouse.service;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.realm.domain.Realm;

import java.util.List;

public interface AuctionHouseSnapshotService {
    List<AuctionHouseSnapshot> findByRealm(Realm realm);

    void deleteByRealm(Realm realm);
}

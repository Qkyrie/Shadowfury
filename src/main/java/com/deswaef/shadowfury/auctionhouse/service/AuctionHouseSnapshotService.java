package com.deswaef.shadowfury.auctionhouse.service;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import rx.Observable;

import java.util.List;

public interface AuctionHouseSnapshotService {
    List<AuctionHouseSnapshot> findByRealm(Realm realm);

    Long countByRealm(Realm realm);

    Observable<ServerMessage> doImport(Realm realm);

    void deleteByRealm(Realm realm);

    void create(Iterable<AuctionHouseSnapshot> snapshots);
}

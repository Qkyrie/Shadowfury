package com.deswaef.shadowfury.auctionhouse.service;

import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import rx.Observable;

public interface AuctionHouseStatisticService {
    Observable<ServerMessage> statify(Realm realm);
}

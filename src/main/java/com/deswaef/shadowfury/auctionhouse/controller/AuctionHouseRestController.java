package com.deswaef.shadowfury.auctionhouse.controller;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.auctionhouse.service.AuctionHouseSnapshotService;
import com.deswaef.shadowfury.realm.domain.Locality;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.realm.service.RealmService;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/auctions")
public class AuctionHouseRestController {

    @Autowired
    private AuctionHouseSnapshotService auctionHouseSnapshotService;

    @Autowired
    private RealmService realmService;

    @RequestMapping(value = "/{locality}/{realm}/import", method = GET)
    public DeferredResult<ServerMessage> doImport(@PathVariable("realm") String realm, @PathVariable("locality") Locality locality) {
        Optional<Realm> silvermoon = realmService.findBySlug(realm, locality);
        DeferredResult<ServerMessage> deferred = new DeferredResult<>();
        Observable<ServerMessage> serverMessageObservable = auctionHouseSnapshotService.doImport(silvermoon.get());
        serverMessageObservable.subscribe(deferred::setResult, deferred::setErrorResult);
        return deferred;
    }

    @RequestMapping(method = GET, value = "/{locality}/{realm}/count")
         public long count(@PathVariable("realm") String realm, @PathVariable("locality") Locality locality) {
        Optional<Realm> actualRealm = realmService.findBySlug(realm, locality);
        return auctionHouseSnapshotService.countByRealm(actualRealm.get());
    }

    @RequestMapping(method = GET, value = "/{locality}/{realm}/statify")
    public DeferredResult<ServerMessage> statify(@PathVariable("realm") String realm, @PathVariable("locality") Locality locality) {
        Optional<Realm> actualRealm = realmService.findBySlug(realm, locality);
        return null;
        //TODO
    }
}

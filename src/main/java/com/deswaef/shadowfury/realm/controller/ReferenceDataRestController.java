package com.deswaef.shadowfury.realm.controller;

import com.deswaef.shadowfury.item.service.ItemService;
import com.deswaef.shadowfury.realm.domain.Locality;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.realm.importer.RealmImporter;
import com.deswaef.shadowfury.realm.service.RealmService;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/referencedata")
public class ReferenceDataRestController {

    @Autowired
    private RealmService realmService;
    @Autowired
    private RealmImporter realmImporter;
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = GET, value = "/realms")
    public List<Realm> realms() {
        return realmService.findAll();
    }

    @RequestMapping(method = GET, value = "/realms/{locality}/count")
    public long realms(@PathVariable("locality") Locality locality) {
        return realmService.count(locality);
    }

    @RequestMapping(value = "/realms/{locality}/import", method = RequestMethod.POST)
    public DeferredResult<ServerMessage> importFor(@PathVariable("locality") Locality locality) {
        DeferredResult<ServerMessage> deffered = new DeferredResult<>();
        Observable<ServerMessage> serverMessageObservable = realmImporter.doImport(locality);
        serverMessageObservable.subscribe(deffered::setResult, deffered::setErrorResult);
        return deffered;
    }

    @RequestMapping(value = "/items/count")
    public long countItems() {
        return itemService.count();
    }

}


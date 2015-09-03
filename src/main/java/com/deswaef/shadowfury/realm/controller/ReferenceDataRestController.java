package com.deswaef.shadowfury.realm.controller;

import com.deswaef.shadowfury.realm.domain.Locality;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.realm.importer.RealmImporter;
import com.deswaef.shadowfury.realm.service.RealmService;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/referencedata/realms")
public class ReferenceDataRestController {

    @Autowired
    private RealmService realmService;
    @Autowired
    private RealmImporter realmImporter;

    @RequestMapping(method = GET)
    public List<Realm> realms() {
        return realmService.findAll();
    }

    @RequestMapping("/import/{locality}")
    public DeferredResult<ServerMessage> importFor(@PathVariable("locality") Locality locality) {
        DeferredResult<ServerMessage> deffered = new DeferredResult<>();
        Observable<ServerMessage> serverMessageObservable = realmImporter.doImport(locality);
        serverMessageObservable.subscribe(deffered::setResult, deffered::setErrorResult);
        return deffered;
    }

}

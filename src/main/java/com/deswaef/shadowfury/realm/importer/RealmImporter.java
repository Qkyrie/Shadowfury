package com.deswaef.shadowfury.realm.importer;

import com.deswaef.shadowfury.battlenet.configuration.Battlenet;
import com.deswaef.shadowfury.realm.domain.Locality;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.realm.service.RealmService;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
public class RealmImporter {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Autowired
    private Map<String, Battlenet> battlenets;

    @Autowired
    private RealmService realmService;

    public Observable<ServerMessage> doImport(Locality locality) {
        return Observable.<ServerMessage>create(s -> {
                    try {
                        if (realmService.count(locality) > 0) {
                            s.onNext(ServerMessage
                                    .Builder
                                    .create()
                                    .withMessage("Realms for locality " + locality.getLocalityName() + " were already imported"));
                        } else  {
                            if (battlenets.containsKey(locality.getLocalityName())) {
                                List<Realm> newRealms = battlenets.get(locality.getLocalityName())
                                        .referencedata()
                                        .realms()
                                        .getRealms()
                                        .stream()
                                        .map(battlenetRealm -> new Realm()
                                                        .setLocality(locality)
                                                        .setName(battlenetRealm.getName())
                                                        .setSlug(battlenetRealm.getSlug())
                                        ).collect(Collectors.toList());
                                realmService.create(newRealms);
                                s.onNext(ServerMessage
                                        .Builder
                                        .create()
                                        .withMessage(String.format("done importing realms for locality: %s", locality.getLocalityName())));
                            } else {
                                s.onNext(ServerMessage
                                                .Builder
                                                .create()
                                                .withMessage(String.format("Couldn't import realms. There is no active client for locality: %s", locality.getLocalityName()))
                                );
                            }
                        }
                    } catch (Exception ex) {
                        s.onNext(ServerMessage
                                .Builder
                                .create()
                                .withMessage(String.format("Couldn't import realms. Something unexpected happened! %s", ex.getMessage())
                                ));
                    }
                    s.onCompleted();
                }
        ).subscribeOn(Schedulers.from(executorService));
    }

}

package com.deswaef.shadowfury.auctionhouse.service;


import com.deswaef.shadowfury.auctionhouse.domain.SnapshotRealmConfiguration;
import com.deswaef.shadowfury.realm.domain.Realm;

import java.util.Optional;

public interface SnapshotRealmConfigurationService {
    Optional<SnapshotRealmConfiguration> findByRealm(Realm realm);
}

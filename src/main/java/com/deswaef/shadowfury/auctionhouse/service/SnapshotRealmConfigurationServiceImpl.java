package com.deswaef.shadowfury.auctionhouse.service;

import com.deswaef.shadowfury.auctionhouse.domain.SnapshotRealmConfiguration;
import com.deswaef.shadowfury.auctionhouse.repository.SnapshotRealmConfigurationRepository;
import com.deswaef.shadowfury.realm.domain.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SnapshotRealmConfigurationServiceImpl implements SnapshotRealmConfigurationService {

    @Autowired
    private SnapshotRealmConfigurationRepository snapshotRealmConfigurationRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<SnapshotRealmConfiguration> findByRealm(Realm realm) {
        return snapshotRealmConfigurationRepository.findByRealm(realm);
    }


}

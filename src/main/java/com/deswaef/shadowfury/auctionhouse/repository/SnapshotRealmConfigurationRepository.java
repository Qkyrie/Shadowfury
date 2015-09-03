package com.deswaef.shadowfury.auctionhouse.repository;

import com.deswaef.shadowfury.auctionhouse.domain.SnapshotRealmConfiguration;
import com.deswaef.shadowfury.infrastructure.repository.JpaRepository;
import com.deswaef.shadowfury.realm.domain.Realm;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SnapshotRealmConfigurationRepository extends JpaRepository<SnapshotRealmConfiguration, Long>{

    Optional<SnapshotRealmConfiguration> findByRealm(@Param("realm") Realm realm);
}

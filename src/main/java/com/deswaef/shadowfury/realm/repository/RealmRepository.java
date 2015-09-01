package com.deswaef.shadowfury.realm.repository;

import com.deswaef.shadowfury.infrastructure.repository.JpaRepository;
import com.deswaef.shadowfury.realm.domain.Locality;
import com.deswaef.shadowfury.realm.domain.Realm;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RealmRepository extends JpaRepository<Realm, Long> {
    Optional<Realm> findByNameAndLocality(@Param("name") String name, @Param("locality") Locality locality);
}

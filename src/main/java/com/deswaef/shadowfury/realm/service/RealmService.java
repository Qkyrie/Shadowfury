package com.deswaef.shadowfury.realm.service;

import com.deswaef.shadowfury.realm.domain.Locality;
import com.deswaef.shadowfury.realm.domain.Realm;

import java.util.List;
import java.util.Optional;

public interface RealmService {
    long count(Locality locality);
    Realm create(Realm realm);
    List<Realm> create(Iterable<Realm> entities);
    List<Realm> findAll();
    Optional<Realm> findBySlug(String slug, Locality locality);
}

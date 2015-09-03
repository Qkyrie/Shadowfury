package com.deswaef.shadowfury.realm.service;

import com.deswaef.shadowfury.realm.domain.Locality;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.realm.repository.RealmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RealmServiceImpl implements RealmService {

    @Autowired
    private RealmRepository realmRepository;

    @Override
    @Transactional(readOnly = true)
    public long count(Locality locality) {
        return realmRepository.countByLocality(locality);
    }

    @Override
    @Transactional
    public Realm create(Realm realm) {
        return realmRepository.save(realm);
    }

    @Transactional
    @Override
    public List<Realm> create(Iterable<Realm> entities) {
        return realmRepository.save(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Realm> findAll() {
        return realmRepository.findAll();
    }

    @Override
    public Optional<Realm> findBySlug(String slug, Locality locality) {
        return realmRepository.findBySlugAndLocality(slug, locality);
    }

}

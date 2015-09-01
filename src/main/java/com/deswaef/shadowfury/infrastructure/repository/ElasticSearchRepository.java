package com.deswaef.shadowfury.infrastructure.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface ElasticSearchRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
}

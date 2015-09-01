package com.deswaef.shadowfury.configuration;


import com.deswaef.shadowfury.ShadowFury;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackageClasses = ShadowFury.class)
public class ElasticSearchConfiguration {
    
}

package com.deswaef.shadowfury.configuration;

import com.deswaef.shadowfury.ShadowFury;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = ShadowFury.class)
public class JpaConfiguration {
}

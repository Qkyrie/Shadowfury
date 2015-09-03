package com.deswaef.shadowfury.battlenet.configuration;

import com.deswaef.shadowfury.realm.domain.Locality;
import org.elasticsearch.common.collect.Maps;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "battlenet")
public class BattlenetAutoConfiguration {

    private URLS urls;
    private String apikey;

    public static class URLS {
        private String eu;
        private String us;

        public URLS() {
        }

        public String getEu() {
            return eu;
        }

        public String getUs() {
            return us;
        }

        public URLS setEu(String eu) {
            this.eu = eu;
            return this;
        }

        public URLS setUs(String us) {
            this.us = us;
            return this;
        }
    }

    @Bean
    public Map<String, Battlenet> provideBattlenetMaps(@Qualifier("eu") Battlenet euBattlenet, @Qualifier("us") Battlenet usBattlenet) {
        Map<String, Battlenet> newMap = Maps.newHashMap();
        newMap.put(Locality.EU.getLocalityName(), euBattlenet);
        newMap.put(Locality.US.getLocalityName(), usBattlenet);
        return newMap;
    }


    @Bean
    @Qualifier("eu")
    @Primary
    public Battlenet eu() {
        return Battlenet.newInstance(
                urls.eu,
                apikey
        );
    }

    @Bean
    @Qualifier("us")
    public Battlenet us() {
        return Battlenet.newInstance(
                urls.us,
                apikey
        );
    }


    public String getApikey() {
        return apikey;
    }

    public BattlenetAutoConfiguration setApikey(String apikey) {
        this.apikey = apikey;
        return this;
    }

    public URLS getUrls() {
        return urls;
    }

    public BattlenetAutoConfiguration setUrls(URLS urls) {
        this.urls = urls;
        return this;
    }
}

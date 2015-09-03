package com.deswaef.shadowfury.battlenet.configuration;

import com.deswaef.shadowfury.infrastructure.repository.ShadowfuryIntegrationTest;
import com.deswaef.shadowfury.realm.domain.Locality;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class BattlenetAutoConfigurationTest extends ShadowfuryIntegrationTest {

    @Autowired
    private Battlenet defaultBattlenet;
    @Autowired
    @Qualifier("eu")
    private Battlenet euBattlenet;
    @Autowired
    @Qualifier("us")
    private Battlenet usBattlenet;
    @Autowired
    private Map<String, Battlenet> battlenetMap;

    @Test
    public void defaultIsEuBattlenet() throws Exception {
        assertThat(defaultBattlenet.getBaseUrl()).isEqualToIgnoringCase("https://eu.api.battle.net");
    }

    @Test
    public void euBattlenetHasEuBattlenetUrl() throws Exception {
        assertThat(euBattlenet.getBaseUrl()).isEqualToIgnoringCase("https://eu.api.battle.net");
    }

    @Test
    public void usBattlenetHasUsBattlenetUrl() throws Exception {
        assertThat(usBattlenet.getBaseUrl()).isEqualToIgnoringCase("https://us.api.battle.net");
    }

    @Test
    public void battlenetMapContainsAllBattlenets() throws Exception {
        assertThat(battlenetMap.get(Locality.EU.getLocalityName())).isNotNull();
        assertThat(battlenetMap.get(Locality.US.getLocalityName())).isNotNull();
    }
}
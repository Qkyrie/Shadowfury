package com.deswaef.shadowfury.battlenet.api.dataresources;

import com.deswaef.shadowfury.AbstractMockedTest;
import com.deswaef.shadowfury.battlenet.api.dataresources.api.ClassesResponse;
import com.deswaef.shadowfury.battlenet.api.dataresources.api.RacesResponse;
import com.deswaef.shadowfury.battlenet.api.dataresources.api.RealmsResponse;
import com.deswaef.shadowfury.battlenet.configuration.ApiKeyRequestInterceptor;
import com.deswaef.shadowfury.battlenet.configuration.OkHttpClientProvider;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class DataResourcesResourceTest extends AbstractMockedTest {

    private DataResourcesResource dataResourcesResource;

    @Before
    public void setUp() throws Exception {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://eu.api.battle.net")
                .setClient(OkHttpClientProvider.provide())
                .setRequestInterceptor(new ApiKeyRequestInterceptor(apiKey()))
                .build();
        this.dataResourcesResource = new DataResourcesResource().url(restAdapter);
    }

    @Test
    public void gettingAllRacesResultInGoodData() throws Exception {
        RacesResponse races = dataResourcesResource.races();
        assertThat(races.getRaces().size()).isGreaterThan(0);
        races.getRaces()
                .forEach(x -> {
                            assertThat(x.getId()).isGreaterThan(0);
                            assertThat(x.getMask()).isGreaterThan(0);
                            assertThat(x.getSide()).isIn(RacesResponse.Race.Faction.values());
                            assertThat(x.getName()).isNotNull();
                        }
                );
    }

    @Test
    public void gettingAllClassesResultInGoodData() throws Exception {
        ClassesResponse classes = dataResourcesResource.classes();
        assertThat(classes.getClasses().size()).isGreaterThan(0);
        classes.getClasses()
                .forEach(x -> {
                            assertThat(x.getId()).isGreaterThan(0);
                            assertThat(x.getMask()).isGreaterThan(0);
                            assertThat(x.getPowerType()).isNotEmpty();
                            assertThat(x.getName()).isNotNull();
                        }
                );
    }

    @Test
    public void gettingRealmstatusResultsInGoodData() throws Exception {
        RealmsResponse realms = dataResourcesResource.realms();
        assertThat(realms.getRealms().size()).isGreaterThan(0);
        realms.getRealms()
                .forEach(x -> {
                    assertThat(x.getName()).isNotEmpty();
                    assertThat(x.getSlug()).isNotEmpty();
                });
    }
}
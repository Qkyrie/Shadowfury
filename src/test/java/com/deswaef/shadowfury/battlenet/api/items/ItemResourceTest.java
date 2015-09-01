package com.deswaef.shadowfury.battlenet.api.items;

import com.deswaef.shadowfury.AbstractMockedTest;
import com.deswaef.shadowfury.battlenet.api.items.model.Item;
import com.deswaef.shadowfury.battlenet.configuration.ApiKeyRequestInterceptor;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class ItemResourceTest extends AbstractMockedTest {

    private ItemResource itemResource;

    @Before
    public void setUp() throws Exception {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://eu.api.battle.net")
                .setRequestInterceptor(new ApiKeyRequestInterceptor(apiKey()))
                .build();
        itemResource = new ItemResource().url(restAdapter);
    }

    @Test
    public void itemContainsBasicInformation() throws Exception {
        Item item = itemResource.item(18803);
        assertThat(item.getDescription()).isNotEmpty();
        assertThat(item.getIcon()).isNotEmpty();
        assertThat(item.getId()).isEqualTo(18803);
        assertThat(item.getName()).isNotEmpty();
    }
}
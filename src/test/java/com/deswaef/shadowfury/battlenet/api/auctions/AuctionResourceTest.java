package com.deswaef.shadowfury.battlenet.api.auctions;

import com.deswaef.shadowfury.AbstractMockedTest;
import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionResponse;
import com.deswaef.shadowfury.battlenet.configuration.ApiKeyRequestInterceptor;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import static org.assertj.core.api.Assertions.assertThat;

public class AuctionResourceTest extends AbstractMockedTest {

    private RestAdapter restAdapter;
    private AuctionResource auctionResource;
    @Before
    public void setUp() throws Exception {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://eu.api.battle.net/wow")
                .setRequestInterceptor(new ApiKeyRequestInterceptor(apiKey()))
                .build();
        auctionResource = new AuctionResource()
                .url(restAdapter);
    }

    @Test
    public void testSilvermoonReturnsInformation() throws Exception {
        AuctionResponse silvermoon = auctionResource.auctionInformation("silvermoon");
        assertThat(silvermoon.getFiles().size()).isGreaterThan(0);
        assertThat(silvermoon.getFiles().get(0).getLastModified()).isGreaterThan(0);
    }


}
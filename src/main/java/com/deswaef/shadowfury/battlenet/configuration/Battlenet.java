package com.deswaef.shadowfury.battlenet.configuration;

import com.deswaef.shadowfury.battlenet.api.auctions.AuctionResource;
import retrofit.RestAdapter;

public class Battlenet {

    private String url;
    private RestAdapter restAdapter;

    private AuctionResource auctionResource;

    private Battlenet() {
    }

    public static Battlenet newBattlenetInstance(
            String baseUrl,
            String apiKey,
            String clientSecret,
            String redirectUrl
    ) {
        return new Battlenet()
                .url(createRestAdapter(baseUrl, apiKey))
                .auctions(new AuctionResource());
    }

    private static RestAdapter createRestAdapter(String baseUrl, String apiKey) {
        return new RestAdapter
                .Builder()
                .setEndpoint(baseUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(new ApiKeyRequestInterceptor(apiKey))
                .build();
    }

    public AuctionResource auctions() {
        return auctionResource;
    }

    public Battlenet auctions(AuctionResource auctionResource) {
        this.auctionResource = auctionResource.url(restAdapter);
        return this;
    }

    public Battlenet url(RestAdapter restAdapter){
        this.restAdapter = restAdapter;
        return this;
    }
}

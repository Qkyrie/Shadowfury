package com.deswaef.shadowfury.battlenet.api.auctions;

import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionResponse;
import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionSnapshot;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

import java.util.Optional;

public class AuctionResource {

    private AuctionService auctionService;
    private AuctionDataService auctionDataService = new AuctionDataService();

    public AuctionResponse auctionInformation(String realm) {
        try {
            return this.auctionService.auctionInformation(realm);
        } catch (RetrofitError error) {
            throw new IllegalArgumentException("eror: " + error.getResponse().getStatus() + " -> " +error.getResponse().getReason());
        }
    }

    public Optional<AuctionSnapshot> auctionData(String fullUrl) {
        return auctionDataService.getAuctionData(fullUrl);
    }

    public AuctionResource url(RestAdapter restAdapter) {
        this.auctionService = restAdapter.create(AuctionService.class);
        return this;
    }

}

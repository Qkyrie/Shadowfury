package com.deswaef.shadowfury.battlenet.api.auctions;

import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionResponse;
import retrofit.http.GET;
import retrofit.http.Path;

public interface AuctionService {

    @GET("/wow/auction/data/{realm}")
    AuctionResponse auctionInformation(@Path("realm") String realm);

}

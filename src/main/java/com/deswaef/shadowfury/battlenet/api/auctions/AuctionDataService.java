package com.deswaef.shadowfury.battlenet.api.auctions;

import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionSnapshot;
import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class AuctionDataService {

    public Optional<AuctionSnapshot> getAuctionData(String fullUrl) {
        try {
            RestTemplate template = new RestTemplate();
            String forObject = template.getForObject(fullUrl, String.class);
            return Optional.of(new Gson().fromJson(forObject, AuctionSnapshot.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

}

package com.deswaef.shadowfury.battlenet.api.auctions.model;

import java.util.List;

public class AuctionSnapshot  {

    private List<AuctionItem> auctions;

    public List<AuctionItem> getAuctions() {
        return auctions;
    }

    public AuctionSnapshot setAuctions(List<AuctionItem> auctions) {
        this.auctions = auctions;
        return this;
    }
}

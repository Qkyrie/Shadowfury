package com.deswaef.shadowfury.battlenet.api.auctions.model;

import java.util.List;

public class AuctionSnapshot  {

    private AuctionInnerSnapshot auctions;

    public AuctionInnerSnapshot getAuctions() {
        return auctions;
    }

    public void setAuctions(AuctionInnerSnapshot auctions) {
        this.auctions = auctions;
    }

    public static final class AuctionInnerSnapshot {

        private List<AuctionItem> auctions;

        public List<AuctionItem> getAuctions() {
            return auctions;
        }

        public void setAuctions(List<AuctionItem> auctions) {
            this.auctions = auctions;
        }

    }
}

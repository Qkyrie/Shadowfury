package com.deswaef.shadowfury.auctionhouse.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "auctionhousesnapshot", type = "auctionhousesnapshot", shards = 1)
public class AuctionHouseSnapshot {

    @Id
    private Long auctionId;
    private Long itemId;
    private String owner;
    private Long bid;
    private Long buyout;
    private int quantity;
    private String timeLeft;
    private Long realm;

    public Long getAuctionId() {
        return auctionId;
    }

    public AuctionHouseSnapshot setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
        return this;
    }

    public Long getItemId() {
        return itemId;
    }

    public AuctionHouseSnapshot setItemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public AuctionHouseSnapshot setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public Long getBid() {
        return bid;
    }

    public AuctionHouseSnapshot setBid(Long bid) {
        this.bid = bid;
        return this;
    }

    public Long getBuyout() {
        return buyout;
    }

    public AuctionHouseSnapshot setBuyout(Long buyout) {
        this.buyout = buyout;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public AuctionHouseSnapshot setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public AuctionHouseSnapshot setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
        return this;
    }

    public Long getRealm() {
        return realm;
    }

    public AuctionHouseSnapshot setRealm(Long realm) {
        this.realm = realm;
        return this;
    }
}

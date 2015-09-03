package com.deswaef.shadowfury.auctionhouse.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;


@Document(indexName = "auctionhousesnapshot", type = "auctionhousesnapshot", shards = 1)
public class AuctionHouseSnapshot {

    @Id
    private Long auctionId;
    @Field(
            type = FieldType.Long,
            store = true
    )
    private Long itemId;
    @Field(
            type = FieldType.String,
            store = true
    )
    private String owner;
    @Field(
            type = FieldType.Double,
            store = true
    )
    private Double bid;
    @Field(
            type = FieldType.Double,
            store = true
    )
    private Double buyout;
    @Field(
            type = FieldType.Long,
            store = true
    )
    private Long quantity;
    @Field(
            type = FieldType.String,
            store = true
    )
    private String timeLeft;
    @Field(
            type = FieldType.Long,
            store = true
    )
    private Long realm;
    @Field(
            type = FieldType.Date,
            store = true
    )
    private Date exportTime;

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

    public Double getBid() {
        return bid;
    }

    public AuctionHouseSnapshot setBid(Double bid) {
        this.bid = bid;
        return this;
    }

    public Double getBuyout() {
        return buyout;
    }

    public AuctionHouseSnapshot setBuyout(Double buyout) {
        this.buyout = buyout;
        return this;
    }

    public Long getQuantity() {
        return quantity;
    }

    public AuctionHouseSnapshot setQuantity(Long quantity) {
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

    public Date getExportTime() {
        return exportTime;
    }

    public AuctionHouseSnapshot setExportTime(Date exportTime) {
        this.exportTime = exportTime;
        return this;
    }
}

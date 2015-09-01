package com.deswaef.shadowfury.auctionhouse.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "auctionhousestatistic", type = "auctionhousestatistic")
public class AuctionHouseStatistic {

    @Id
    private Long id;
    @Field(
            type = FieldType.Long,
            store = true
    )
    private Long realm;
    @Field(
            type = FieldType.Long,
            store = true
    )
    private Long item;
    @Field(
            type = FieldType.Double,
            store = true
    )
    private Double minimumBid;
    @Field(
            type = FieldType.Double,
            store = true
    )
    private Double minimumBuyout;
    @Field(
            type = FieldType.Double,
            store = true
    )
    private Double maximumBid;
    @Field(
            type = FieldType.Double,
            store = true
    )
    private Double maximumBuyout;
    @Field(
            type = FieldType.Long,
            store = true
    )
    private Long quantity;
    private Double averageBid;
    @Field(
            type = FieldType.Double,
            store = true
    )
    private Double averageBuyout;
    @Field(
            type = FieldType.Date,
            store = true
    )
    private Date exportTime;

    public Long getId() {
        return id;
    }

    public AuctionHouseStatistic setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getRealm() {
        return realm;
    }

    public AuctionHouseStatistic setRealm(Long realm) {
        this.realm = realm;
        return this;
    }

    public Long getItem() {
        return item;
    }

    public AuctionHouseStatistic setItem(Long item) {
        this.item = item;
        return this;
    }

    public Double getMinimumBid() {
        return minimumBid;
    }

    public AuctionHouseStatistic setMinimumBid(Double minimumBid) {
        this.minimumBid = minimumBid;
        return this;
    }

    public Double getMinimumBuyout() {
        return minimumBuyout;
    }

    public AuctionHouseStatistic setMinimumBuyout(Double minimumBuyout) {
        this.minimumBuyout = minimumBuyout;
        return this;
    }

    public Double getMaximumBid() {
        return maximumBid;
    }

    public AuctionHouseStatistic setMaximumBid(Double maximumBid) {
        this.maximumBid = maximumBid;
        return this;
    }

    public Double getMaximumBuyout() {
        return maximumBuyout;
    }

    public AuctionHouseStatistic setMaximumBuyout(Double maximumBuyout) {
        this.maximumBuyout = maximumBuyout;
        return this;
    }

    public Long getQuantity() {
        return quantity;
    }

    public AuctionHouseStatistic setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    public Double getAverageBid() {
        return averageBid;
    }

    public AuctionHouseStatistic setAverageBid(Double averageBid) {
        this.averageBid = averageBid;
        return this;
    }

    public Double getAverageBuyout() {
        return averageBuyout;
    }

    public AuctionHouseStatistic setAverageBuyout(Double averageBuyout) {
        this.averageBuyout = averageBuyout;
        return this;
    }

    public Date getExportTime() {
        return exportTime;
    }

    public AuctionHouseStatistic setExportTime(Date exportTime) {
        this.exportTime = exportTime;
        return this;
    }
}

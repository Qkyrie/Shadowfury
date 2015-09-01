package com.deswaef.shadowfury.auctionhouse.converting;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseStatistic;
import org.elasticsearch.common.collect.ImmutableMap;
import org.elasticsearch.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

@Component
public class AuctionHouseSnapshotToStatisticConverter {

    public List<AuctionHouseStatistic> convert(Long realm, List<AuctionHouseSnapshot> auctionhouseSnapshots) {
        Map<Long, List<AuctionHouseSnapshot>> auctionsPerItem = getAuctionsPerItem(auctionhouseSnapshots);
        return auctionsPerItem
                .entrySet()
                .stream()
                .map(x -> convertFromAuctionSnapshots(x, x.getKey(), realm))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<AuctionHouseStatistic> convertFromAuctionSnapshots(Map.Entry<Long, List<AuctionHouseSnapshot>> auctionsPerItem,
                                                                        Long itemId,
                                                                        Long realmId) {
        DoubleSummaryStatistics bidStatistics = getStatisticsFor(auctionsPerItem.getValue(), AuctionHouseSnapshot::getBid);
        DoubleSummaryStatistics buyoutStatistics = getStatisticsFor(auctionsPerItem.getValue(), AuctionHouseSnapshot::getBuyout);
        long quantity = auctionsPerItem.getValue().stream()
                .mapToLong(AuctionHouseSnapshot::getQuantity)
                .sum();
        return Optional.of(new AuctionHouseStatistic()
                        .setAverageBid(bidStatistics.getAverage())
                        .setMinimumBid(bidStatistics.getMin())
                        .setMaximumBid(bidStatistics.getMax())
                        .setAverageBuyout(buyoutStatistics.getAverage())
                        .setMinimumBuyout(buyoutStatistics.getMin())
                        .setMaximumBuyout(buyoutStatistics.getMax())
                        .setExportTime(new Date())
                        .setRealm(realmId)
                        .setItem(itemId)
                        .setQuantity(quantity)
        );
    }

    private DoubleSummaryStatistics getStatisticsFor(List<AuctionHouseSnapshot> snapshots, ToDoubleFunction<? super AuctionHouseSnapshot> toDoubleFunction) {
        return snapshots
                .stream()
                .mapToDouble(toDoubleFunction)
                .summaryStatistics();
    }

    private Map<Long, List<AuctionHouseSnapshot>> getAuctionsPerItem(List<AuctionHouseSnapshot> auctionhouseSnapshots) {
        return auctionhouseSnapshots
                .stream()
                .collect(Collectors.groupingBy(AuctionHouseSnapshot::getItemId));
    }

}

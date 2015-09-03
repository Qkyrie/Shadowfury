package com.deswaef.shadowfury.auctionhouse.converting;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionItem;
import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionSnapshot;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BattlenetAuctionToSnapshotConverter {

    public List<AuctionHouseSnapshot> convert(Long realm,
                                              AuctionSnapshot auctionSnapshot,
                                              Long lastModified) {
        return auctionSnapshot
                .getAuctions()
                .stream()
                .map(x -> this.transform(x, realm))
                .map(x -> x.setExportTime(new Date(lastModified)))
                .collect(Collectors.toList());
    }

    private AuctionHouseSnapshot transform(AuctionItem auctionItem, Long realm) {
        return new AuctionHouseSnapshot()
                .setBid((double) (auctionItem.getBid() != null ? auctionItem.getBid() : 0))
                .setBuyout((double) (auctionItem.getBuyout() != null ? auctionItem.getBuyout() : 0L))
                .setItemId(auctionItem.getItem())
                .setOwner(auctionItem.getOwner())
                .setRealm(realm)
                .setQuantity((long) auctionItem.getQuantity())
                .setAuctionId(auctionItem.getAuc())
                .setTimeLeft(auctionItem.getTimeLeft());
    }
}

package com.deswaef.shadowfury.auctionhouse.converting;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionItem;
import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionSnapshot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BattlenetAuctionToSnapshotConverter {

    List<AuctionHouseSnapshot> convert(Long realm, AuctionSnapshot auctionSnapshot) {
        return auctionSnapshot
                .getAuctions()
                .getAuctions()
                .stream()
                .map(x -> this.transform(x, realm))
                .collect(Collectors.toList());
    }

    private AuctionHouseSnapshot transform(AuctionItem auctionItem, Long realm) {
        return new AuctionHouseSnapshot()
                .setBid(auctionItem.getBid() != null ? auctionItem.getBid() : 0L)
                .setBuyout(auctionItem.getBuyout() != null ? auctionItem.getBuyout() : 0L)
                .setItemId(auctionItem.getItem())
                .setOwner(auctionItem.getOwner())
                .setRealm(realm)
                .setQuantity(auctionItem.getQuantity())
                .setAuctionId(auctionItem.getAuc())
                .setTimeLeft(auctionItem.getTimeLeft());
    }
}

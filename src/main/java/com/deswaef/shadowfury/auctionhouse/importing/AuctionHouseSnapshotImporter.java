package com.deswaef.shadowfury.auctionhouse.importing;

import com.deswaef.shadowfury.auctionhouse.converting.BattlenetAuctionToSnapshotConverter;
import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.auctionhouse.service.AuctionHouseSnapshotService;
import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionResponse;
import com.deswaef.shadowfury.battlenet.api.auctions.model.AuctionSnapshot;
import com.deswaef.shadowfury.battlenet.configuration.Battlenet;
import com.deswaef.shadowfury.realm.domain.Realm;
import com.deswaef.shadowfury.servermessage.domain.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class AuctionHouseSnapshotImporter {

    @Autowired
    private Map<String, Battlenet> battlenetMap;
    @Autowired
    private BattlenetAuctionToSnapshotConverter battlenetAuctionToSnapshotConverter;
    @Autowired
    private AuctionHouseSnapshotService auctionHouseSnapshotService;


    public ServerMessage importAuctionHouseSnapshots(Realm realm) {
        Battlenet battlenet = battlenetMap.get(realm.getLocality().getLocalityName());
        AuctionResponse auctionResponse = battlenet
                .auctions()
                .auctionInformation(realm.getSlug());
        if (auctionResponse.getFiles() != null) {
            auctionHouseSnapshotService.deleteByRealm(realm);
            auctionResponse.getFiles()
                    .forEach(file -> importFile(battlenet, file, realm));
        }
        return ServerMessage.Builder
                .create()
                .withMessage("imported snapshots for realm")
                .success()
                .build();
    }

    private void importFile(Battlenet battlenet, AuctionResponse.AuctionResponseFile file, Realm realm) {
        String url = file.getUrl();
        Optional<AuctionSnapshot> auctionSnapshot = battlenet
                .auctions()
                .auctionData(url);
        if (auctionSnapshot.isPresent()) {
            List<AuctionHouseSnapshot> convert = battlenetAuctionToSnapshotConverter.convert(realm.getId(), auctionSnapshot.get(), file.getLastModified());
            auctionHouseSnapshotService.create(convert);
        } else {
            throw new IllegalArgumentException("unable to download the auctions file");
        }
    }

}

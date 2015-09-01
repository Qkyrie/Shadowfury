package com.deswaef.shadowfury.auctionhouse.repository;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseSnapshot;
import com.deswaef.shadowfury.infrastructure.repository.ElasticSearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuctionHouseSnapshotRepository extends ElasticSearchRepository<AuctionHouseSnapshot, Long> {
    List<AuctionHouseSnapshot> findByRealm(@Param("realm") Long realm);
}

package com.deswaef.shadowfury.auctionhouse.repository;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseStatistic;
import com.deswaef.shadowfury.infrastructure.repository.CrudRepository;
import com.deswaef.shadowfury.infrastructure.repository.ElasticSearchRepository;
import com.deswaef.shadowfury.infrastructure.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AuctionHouseStatisticRepository extends ElasticSearchRepository<AuctionHouseStatistic, Long> {
    List<AuctionHouseStatistic> readAllByRealmAndExportTime(@Param("realm") long realm, @Param("exportTime") String exportTime);
    long countByRealmAndExportTime(@Param("realm") long realm, @Param("exportTime") String exportTime);
}

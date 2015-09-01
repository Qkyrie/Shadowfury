package com.deswaef.shadowfury.auctionhouse.repository;

import com.deswaef.shadowfury.auctionhouse.domain.AuctionHouseStatistic;
import com.deswaef.shadowfury.infrastructure.repository.CrudRepository;
import com.deswaef.shadowfury.infrastructure.repository.ElasticSearchRepository;
import com.deswaef.shadowfury.infrastructure.repository.JpaRepository;

public interface AuctionHouseStatisticRepository extends ElasticSearchRepository<AuctionHouseStatistic, Long> {

}

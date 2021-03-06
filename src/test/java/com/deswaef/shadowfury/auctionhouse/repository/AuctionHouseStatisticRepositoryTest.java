package com.deswaef.shadowfury.auctionhouse.repository;

import com.deswaef.shadowfury.infrastructure.repository.ShadowfuryIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class AuctionHouseStatisticRepositoryTest extends ShadowfuryIntegrationTest {

    @Autowired
    private AuctionHouseStatisticRepository repository;

    @Test
    public void findAllReturnsList() throws Exception {
        assertThat(repository.findAll()).isNotNull();
    }
}
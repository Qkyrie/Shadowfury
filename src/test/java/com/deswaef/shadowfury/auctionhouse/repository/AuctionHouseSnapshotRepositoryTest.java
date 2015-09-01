package com.deswaef.shadowfury.auctionhouse.repository;

import com.deswaef.shadowfury.infrastructure.repository.RepositoryIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class AuctionHouseSnapshotRepositoryTest extends RepositoryIntegrationTest {

    @Autowired
    private AuctionHouseSnapshotRepository auctionHouseSnapshotRepository;

    @Test
    public void findAllReturnsList() throws Exception {
        assertThat(auctionHouseSnapshotRepository.findAll()).isNotNull();
    }
}
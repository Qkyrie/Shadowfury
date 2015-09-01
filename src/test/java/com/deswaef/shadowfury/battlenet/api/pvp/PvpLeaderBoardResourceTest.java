package com.deswaef.shadowfury.battlenet.api.pvp;

import com.deswaef.shadowfury.AbstractMockedTest;
import com.deswaef.shadowfury.battlenet.api.pvp.model.PvPLeaderboard;
import com.deswaef.shadowfury.battlenet.api.pvp.model.PvPPlayer;
import com.deswaef.shadowfury.battlenet.configuration.ApiKeyRequestInterceptor;
import com.deswaef.shadowfury.battlenet.configuration.OkHttpClientProvider;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class PvpLeaderBoardResourceTest extends AbstractMockedTest {

    private PvpLeaderBoardResource pvpLeaderBoardResource;

    @Before
    public void setUp() throws Exception {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://eu.api.battle.net")
                .setClient(OkHttpClientProvider.provide())
                .setRequestInterceptor(new ApiKeyRequestInterceptor(apiKey()))
                .build();
        this.pvpLeaderBoardResource = new PvpLeaderBoardResource().url(restAdapter);
    }

    @Test
    public void validateAllEntriesFor2v2() throws Exception {
        PvPLeaderboard leaderboard = pvpLeaderBoardResource.leaderboard("2v2");
        validate(leaderboard);
    }

    @Test
    public void validateAllEntriesFor3v3() throws Exception {
        PvPLeaderboard leaderboard = pvpLeaderBoardResource.leaderboard("3v3");
        validate(leaderboard);
    }

    @Test
    public void validateAllEntriesFor5v5() throws Exception {
        PvPLeaderboard leaderboard = pvpLeaderBoardResource.leaderboard("5v5");
        validate(leaderboard);
    }

    @Test
    public void validateAllEntriesForrbg() throws Exception {
        PvPLeaderboard leaderboard = pvpLeaderBoardResource.leaderboard("rbg");
        validate(leaderboard);
    }


    private void validate(PvPLeaderboard leaderboard) {
        assertThat(leaderboard.getRows()).isNotNull();
        leaderboard.getRows()
                .forEach(this::validate);

    }

    private void validate(PvPPlayer pvPPlayer) {
        assertThat(pvPPlayer.getName()).isNotNull();
        assertThat(pvPPlayer.getRanking()).isGreaterThan(0);
        assertThat(pvPPlayer.getRaceId()).isGreaterThan(0);
        assertThat(pvPPlayer.getRating()).isGreaterThan(0);
        assertThat(pvPPlayer.getRealmName()).isNotNull();
        assertThat(pvPPlayer.getRealmSlug()).isNotNull();
    }
}
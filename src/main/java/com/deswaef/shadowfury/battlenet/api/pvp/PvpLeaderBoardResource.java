package com.deswaef.shadowfury.battlenet.api.pvp;

import com.deswaef.shadowfury.battlenet.api.pvp.model.PvPLeaderboard;
import retrofit.RestAdapter;

public class PvpLeaderBoardResource {
    private PvpLeaderboardService pvpLeaderboardService;

    public PvPLeaderboard leaderboard(String bracket) {
        return pvpLeaderboardService.leaderboard(bracket);
    }

    public PvpLeaderBoardResource url(RestAdapter restAdapter) {
        this.pvpLeaderboardService = restAdapter.create(PvpLeaderboardService.class);
        return this;
    }
}

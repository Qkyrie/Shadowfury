package com.deswaef.shadowfury.battlenet.api.pvp;

import com.deswaef.shadowfury.battlenet.api.pvp.model.PvPLeaderboard;
import retrofit.http.GET;
import retrofit.http.Path;

public interface PvpLeaderboardService {

    @GET("/wow/leaderboard/{bracket}")
    PvPLeaderboard leaderboard(@Path("bracket") String bracket);

}

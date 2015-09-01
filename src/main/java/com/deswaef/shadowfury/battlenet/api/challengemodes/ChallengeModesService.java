package com.deswaef.shadowfury.battlenet.api.challengemodes;

import com.deswaef.shadowfury.battlenet.api.challengemodes.model.RealmLeaderBoard;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by QuintenDes on 31/08/15.
 */
public interface ChallengeModesService {

    @GET("/wow/challenge/{realm}")
    RealmLeaderBoard getRealmLeaderboard(@Path("realm") String realm);

}

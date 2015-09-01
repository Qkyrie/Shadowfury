package com.deswaef.shadowfury.battlenet.api.challengemodes;

import com.deswaef.shadowfury.battlenet.api.challengemodes.model.RealmLeaderBoard;
import retrofit.RestAdapter;

/**
 * Created by QuintenDes on 31/08/15.
 */
public class ChallengeModesResource {

    private ChallengeModesService challengeModesService;

    public RealmLeaderBoard getRealmLeaderboard(String realm) {
        return this.challengeModesService.getRealmLeaderboard(realm);
    }


    public ChallengeModesResource url(RestAdapter restAdapter) {
        this.challengeModesService = restAdapter.create(ChallengeModesService.class);
        return this;
    }

}

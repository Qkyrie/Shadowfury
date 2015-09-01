package com.deswaef.shadowfury.battlenet.api.challengemodes.model;

import java.util.List;

/**
 * Created by QuintenDes on 31/08/15.
 */
public class RealmLeaderBoard {

    private List<RealmLeaderBoardChallenge> challenge;

    public List<RealmLeaderBoardChallenge> getChallenge() {
        return challenge;
    }

    public RealmLeaderBoard setChallenge(List<RealmLeaderBoardChallenge> challenge) {
        this.challenge = challenge;
        return this;
    }
}

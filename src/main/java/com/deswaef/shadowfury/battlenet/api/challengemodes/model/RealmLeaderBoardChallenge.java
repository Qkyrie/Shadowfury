package com.deswaef.shadowfury.battlenet.api.challengemodes.model;

import java.util.List;

/**
 * Created by QuintenDes on 31/08/15.
 */
public class RealmLeaderBoardChallenge {

    private RealmLeaderBoardChallengeRealm realm;
    private RealmLeaderBoardChallengeMap map;
    private List<RealmLeaderBoardChallengeGroup> groups;

    public RealmLeaderBoardChallengeRealm getRealm() {
        return realm;
    }

    public RealmLeaderBoardChallenge setRealm(RealmLeaderBoardChallengeRealm realm) {
        this.realm = realm;
        return this;
    }

    public RealmLeaderBoardChallengeMap getMap() {
        return map;
    }

    public RealmLeaderBoardChallenge setMap(RealmLeaderBoardChallengeMap map) {
        this.map = map;
        return this;
    }

    public List<RealmLeaderBoardChallengeGroup> getGroups() {
        return groups;
    }

    public RealmLeaderBoardChallenge setGroups(List<RealmLeaderBoardChallengeGroup> groups) {
        this.groups = groups;
        return this;
    }
}

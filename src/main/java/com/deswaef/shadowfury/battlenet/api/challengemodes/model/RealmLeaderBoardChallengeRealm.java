package com.deswaef.shadowfury.battlenet.api.challengemodes.model;

import java.util.List;

/**
 * Created by QuintenDes on 31/08/15.
 */
public class RealmLeaderBoardChallengeRealm {

    private String name;
    private String slug;
    private String battlegroup;
    private String locale;
    private String timezone;
    private List<String> connected_realms;

    public String getName() {
        return name;
    }

    public RealmLeaderBoardChallengeRealm setName(String name) {
        this.name = name;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public RealmLeaderBoardChallengeRealm setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getBattlegroup() {
        return battlegroup;
    }

    public RealmLeaderBoardChallengeRealm setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
        return this;
    }

    public String getLocale() {
        return locale;
    }

    public RealmLeaderBoardChallengeRealm setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public RealmLeaderBoardChallengeRealm setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public List<String> getConnected_realms() {
        return connected_realms;
    }

    public RealmLeaderBoardChallengeRealm setConnected_realms(List<String> connected_realms) {
        this.connected_realms = connected_realms;
        return this;
    }
}

package com.deswaef.shadowfury.battlenet.api.pvp.model;

public class PvPPlayer {

    private long ranking;
    private long rating;
    private String name;
    private long realmId;
    private String realmName;
    private String realmSlug;
    private int raceId;
    private int classId;
    private int specId;
    private int factionId;
    private int genderId;
    private long seasonWins;
    private long seasonLosses;
    private int weeklyWins;
    private int weeklyLosses;

    public long getRanking() {
        return ranking;
    }

    public long getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public long getRealmId() {
        return realmId;
    }

    public String getRealmName() {
        return realmName;
    }

    public String getRealmSlug() {
        return realmSlug;
    }

    public int getRaceId() {
        return raceId;
    }

    public int getClassId() {
        return classId;
    }

    public int getSpecId() {
        return specId;
    }

    public int getFactionId() {
        return factionId;
    }

    public int getGenderId() {
        return genderId;
    }

    public long getSeasonWins() {
        return seasonWins;
    }

    public long getSeasonLosses() {
        return seasonLosses;
    }

    public int getWeeklyWins() {
        return weeklyWins;
    }

    public int getWeeklyLosses() {
        return weeklyLosses;
    }
}

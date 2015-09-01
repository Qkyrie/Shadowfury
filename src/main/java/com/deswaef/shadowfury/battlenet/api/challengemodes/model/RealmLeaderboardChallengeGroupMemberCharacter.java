package com.deswaef.shadowfury.battlenet.api.challengemodes.model;

import com.google.gson.annotations.SerializedName;

/**
 * apparantly, sometimes, a character can be null due to reasons
 */
public class RealmLeaderboardChallengeGroupMemberCharacter {
    private String name;
    private String realm;
    private String battlegroup;
    @SerializedName(value = "class")
    private int classId;
    private int race;
    private int gender;
    private int level;
    private int achievementPoints;
    private String thumbnail;
    private String guild;
    private String guildRealm;
    private long lastModidified;

    public String getName() {
        return name;
    }

    public String getRealm() {
        return realm;
    }

    public String getBattlegroup() {
        return battlegroup;
    }

    public int getClassId() {
        return classId;
    }

    public int getRace() {
        return race;
    }

    public int getGender() {
        return gender;
    }

    public int getLevel() {
        return level;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getGuild() {
        return guild;
    }

    public String getGuildRealm() {
        return guildRealm;
    }

    public long getLastModidified() {
        return lastModidified;
    }
}

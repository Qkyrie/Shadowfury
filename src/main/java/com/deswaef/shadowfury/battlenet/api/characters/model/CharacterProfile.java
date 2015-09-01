package com.deswaef.shadowfury.battlenet.api.characters.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by QuintenDes on 31/08/15.
 */
public class CharacterProfile {
    private long lastModified;
    private String name;
    private String realm;
    private String battlegroup;
    @SerializedName("class")
    private int classId;
    private int race;
    private int gender;
    private int level;
    private long achievementPoints;
    private String thumbnail;
    private String calcClass;
    private long totalHonorableKills;

    public long getLastModified() {
        return lastModified;
    }

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

    public long getAchievementPoints() {
        return achievementPoints;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getCalcClass() {
        return calcClass;
    }

    public long getTotalHonorableKills() {
        return totalHonorableKills;
    }
}

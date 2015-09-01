package com.deswaef.shadowfury.battlenet.api.guilds.model;

import com.google.gson.annotations.SerializedName;

public class GuildCharacter {

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
    private Spec spec;
    private String guild;
    private String guildRealm;
    private long lastModified;

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

    public Spec getSpec() {
        return spec;
    }

    public String getGuild() {
        return guild;
    }

    public String getGuildRealm() {
        return guildRealm;
    }

    public long getLastModified() {
        return lastModified;
    }

    public static class Spec {
        private String name;
        private String role;
        private String backgroundImage;
        private String icon;
        private String description;
        private int order;
    }

}

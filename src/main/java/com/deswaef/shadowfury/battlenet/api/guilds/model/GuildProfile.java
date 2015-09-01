package com.deswaef.shadowfury.battlenet.api.guilds.model;

public class GuildProfile {
    private long lastModified;
    private String name;
    private String realm;
    private String battlegroup;
    private int level;
    private int side;
    private int achievementPoints;
    private Emblem emblem;

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

    public int getLevel() {
        return level;
    }

    public int getSide() {
        return side;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public Emblem getEmblem() {
        return emblem;
    }

    public static class Emblem {
        private int icon;
        private String iconColor;
        private int border;
        private String borderColor;
        private String backgroundColor;

        public int getIcon() {
            return icon;
        }

        public String getIconColor() {
            return iconColor;
        }

        public int getBorder() {
            return border;
        }

        public String getBorderColor() {
            return borderColor;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }
    }
}

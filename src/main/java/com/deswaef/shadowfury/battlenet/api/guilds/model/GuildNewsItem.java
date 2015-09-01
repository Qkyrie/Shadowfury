package com.deswaef.shadowfury.battlenet.api.guilds.model;

public class GuildNewsItem {
    private String type;
    private String character;
    private long timestamp;
    private int itemId;
    private String context;
    private GuildNewsItemAchievement achievement;

    public String getType() {
        return type;
    }

    public String getCharacter() {
        return character;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getItemId() {
        return itemId;
    }

    public String getContext() {
        return context;
    }

    public GuildNewsItemAchievement getAchievement() {
        return achievement;
    }

    public static class GuildNewsItemAchievement {
        private int id;
        private String title;
        private int points;
        private String description;
        private String icon;
        private boolean accountWide;
        private int factionId;

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public int getPoints() {
            return points;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }

        public boolean isAccountWide() {
            return accountWide;
        }

        public int getFactionId() {
            return factionId;
        }
    }
}

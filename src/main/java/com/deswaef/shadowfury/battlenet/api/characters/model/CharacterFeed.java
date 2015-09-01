package com.deswaef.shadowfury.battlenet.api.characters.model;

import java.util.List;

/**
 * Created by QuintenDes on 31/08/15.
 */
public class CharacterFeed extends CharacterProfile {

    private List<CharacterFeedItem> feed;

    public List<CharacterFeedItem> getFeed() {
        return feed;
    }

    public static class CharacterFeedItem {


        private CharacterFeedItemType type;
        private long timestamp;
        private long itemId;
        private String context;
        private CharacterFeedItemAchievement achievement;
        private boolean featOfStrength;

        public CharacterFeedItemType getType() {
            return type;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public long getItemId() {
            return itemId;
        }

        public String getContext() {
            return context;
        }

        public CharacterFeedItemAchievement getAchievement() {
            return achievement;
        }

        public boolean isFeatOfStrength() {
            return featOfStrength;
        }

        private static class CharacterFeedItemAchievement {
            private long id;
            private String title;
            private long points;
            private String description;
            private String icon;

            public long getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public long getPoints() {
                return points;
            }

            public String getDescription() {
                return description;
            }

            public String getIcon() {
                return icon;
            }
        }

        public enum CharacterFeedItemType {
            LOOT, BOSSKILL, CRITERIA, ACHIEVEMENT
        }
    }
}

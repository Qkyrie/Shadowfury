package com.deswaef.shadowfury.battlenet.api.guilds.model;

import com.google.gson.annotations.SerializedName;

public class GuildChallenge {

    private GuildChallengeRealm realm;

    public static class GuildChallengeRealm {
        private String name;
        private String slug;
        private String battlegroup;
        private String locale;
        private String timezone;
        @SerializedName("connected_realms")
        private String[] connectedRealms;

        public String getName() {
            return name;
        }

        public String getSlug() {
            return slug;
        }

        public String getBattlegroup() {
            return battlegroup;
        }

        public String getLocale() {
            return locale;
        }

        public String getTimezone() {
            return timezone;
        }

        public String[] getConnectedRealms() {
            return connectedRealms;
        }
    }
}

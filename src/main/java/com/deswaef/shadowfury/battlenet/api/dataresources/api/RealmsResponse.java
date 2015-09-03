package com.deswaef.shadowfury.battlenet.api.dataresources.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RealmsResponse {

    private List<Realm> realms;

    public List<Realm> getRealms() {
        return realms;
    }

    public static class Realm {
        private String name;
        private String slug;
        @SerializedName("connected_realms")
        private String[] connectedRealms;

        public String getName() {
            return name;
        }

        public String getSlug() {
            return slug;
        }

        public String[] getConnectedRealms() {
            return connectedRealms;
        }
    }
}

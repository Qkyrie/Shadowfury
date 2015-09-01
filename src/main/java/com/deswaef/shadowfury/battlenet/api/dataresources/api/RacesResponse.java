package com.deswaef.shadowfury.battlenet.api.dataresources.api;

import java.util.List;

public class RacesResponse {

    private List<Race> races;

    public List<Race> getRaces() {
        return races;
    }

    public static class Race {
        private int id;
        private int mask;
        private Faction side;
        private String name;

        public int getId() {
            return id;
        }

        public int getMask() {
            return mask;
        }

        public Faction getSide() {
            return side;
        }

        public String getName() {
            return name;
        }

        public enum Faction {
            alliance, horde, neutral
        }
    }
}

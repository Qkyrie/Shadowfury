package com.deswaef.shadowfury.battlenet.api.dataresources.api;

import java.util.List;

public class ClassesResponse {

    private List<ClassResponse> classes;

    public List<ClassResponse> getClasses() {
        return classes;
    }

    public static class ClassResponse {
        private int id;
        private int mask;
        private String powerType;
        private String name;

        public int getId() {
            return id;
        }

        public int getMask() {
            return mask;
        }

        public String getPowerType() {
            return powerType;
        }

        public String getName() {
            return name;
        }
    }
}

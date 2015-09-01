package com.deswaef.shadowfury.battlenet.api.characters.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CharacterAchievements extends CharacterProfile{

    private Achievements achievements;

    public Achievements getAchievements() {
        return achievements;
    }

    public static class Achievements {
        private LinkedList<Integer> achievementsCompleted;
        private LinkedList<Long> achievementsCompletedTimestamp;

        public LinkedList<Integer> getAchievementsCompleted() {
            return achievementsCompleted;
        }

        public LinkedList<Long> getAchievementsCompletedTimestamp() {
            return achievementsCompletedTimestamp;
        }
    }

}

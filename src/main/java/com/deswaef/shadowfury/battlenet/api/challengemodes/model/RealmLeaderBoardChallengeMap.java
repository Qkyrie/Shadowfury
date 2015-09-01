package com.deswaef.shadowfury.battlenet.api.challengemodes.model;

/**
 * Created by QuintenDes on 31/08/15.
 */
public class RealmLeaderBoardChallengeMap {

    private Long id;
    private String name;
    private String slug;
    private boolean hasChallengeMode;
    private Criteria bronzeCriteria;
    private Criteria silverCriteria;
    private Criteria goldCriteria;

    public Long getId() {
        return id;
    }

    public RealmLeaderBoardChallengeMap setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RealmLeaderBoardChallengeMap setName(String name) {
        this.name = name;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public RealmLeaderBoardChallengeMap setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public boolean isHasChallengeMode() {
        return hasChallengeMode;
    }

    public RealmLeaderBoardChallengeMap setHasChallengeMode(boolean hasChallengeMode) {
        this.hasChallengeMode = hasChallengeMode;
        return this;
    }

    public Criteria getBronzeCriteria() {
        return bronzeCriteria;
    }

    public RealmLeaderBoardChallengeMap setBronzeCriteria(Criteria bronzeCriteria) {
        this.bronzeCriteria = bronzeCriteria;
        return this;
    }

    public Criteria getSilverCriteria() {
        return silverCriteria;
    }

    public RealmLeaderBoardChallengeMap setSilverCriteria(Criteria silverCriteria) {
        this.silverCriteria = silverCriteria;
        return this;
    }

    public Criteria getGoldCriteria() {
        return goldCriteria;
    }

    public RealmLeaderBoardChallengeMap setGoldCriteria(Criteria goldCriteria) {
        this.goldCriteria = goldCriteria;
        return this;
    }

    public static class Criteria {
        private long time;
        private long hours;
        private long minutes;
        private long seconds;
        private long milliseconds;
        private boolean isPositive;

        public long getTime() {
            return time;
        }

        public long getHours() {
            return hours;
        }

        public long getMinutes() {
            return minutes;
        }

        public long getSeconds() {
            return seconds;
        }

        public long getMilliseconds() {
            return milliseconds;
        }

        public boolean isPositive() {
            return isPositive;
        }
    }
}

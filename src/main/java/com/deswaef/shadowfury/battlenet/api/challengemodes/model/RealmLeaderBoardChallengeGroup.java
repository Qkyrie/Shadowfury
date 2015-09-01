package com.deswaef.shadowfury.battlenet.api.challengemodes.model;

import java.util.List;

public class RealmLeaderBoardChallengeGroup {

    private long ranking;
    private Time time;
    private String date;
    private Medal medal;
    private Faction faction;
    private boolean isRecurring;
    private List<RealmLeaderboardChallengeGroupMember> members;

    public long getRanking() {
        return ranking;
    }

    public RealmLeaderBoardChallengeGroup setRanking(long ranking) {
        this.ranking = ranking;
        return this;
    }

    public Time getTime() {
        return time;
    }

    public RealmLeaderBoardChallengeGroup setTime(Time time) {
        this.time = time;
        return this;
    }

    public String getDate() {
        return date;
    }

    public RealmLeaderBoardChallengeGroup setDate(String date) {
        this.date = date;
        return this;
    }

    public Medal getMedal() {
        return medal;
    }

    public RealmLeaderBoardChallengeGroup setMedal(Medal medal) {
        this.medal = medal;
        return this;
    }

    public Faction getFaction() {
        return faction;
    }

    public RealmLeaderBoardChallengeGroup setFaction(Faction faction) {
        this.faction = faction;
        return this;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public RealmLeaderBoardChallengeGroup setIsRecurring(boolean isRecurring) {
        this.isRecurring = isRecurring;
        return this;
    }

    public List<RealmLeaderboardChallengeGroupMember> getMembers() {
        return members;
    }

    public RealmLeaderBoardChallengeGroup setMembers(List<RealmLeaderboardChallengeGroupMember> members) {
        this.members = members;
        return this;
    }

    public static class Time {
        private long time;
        private long hours;
        private long minutes;
        private long seconds;
        private long milliseconds;
        private boolean isPositive;

        public long getTime() {
            return time;
        }

        public Time setTime(long time) {
            this.time = time;
            return this;
        }

        public long getHours() {
            return hours;
        }

        public Time setHours(long hours) {
            this.hours = hours;
            return this;
        }

        public long getMinutes() {
            return minutes;
        }

        public Time setMinutes(long minutes) {
            this.minutes = minutes;
            return this;
        }

        public long getSeconds() {
            return seconds;
        }

        public Time setSeconds(long seconds) {
            this.seconds = seconds;
            return this;
        }

        public long getMilliseconds() {
            return milliseconds;
        }

        public Time setMilliseconds(long milliseconds) {
            this.milliseconds = milliseconds;
            return this;
        }

        public boolean isPositive() {
            return isPositive;
        }

        public Time setIsPositive(boolean isPositive) {
            this.isPositive = isPositive;
            return this;
        }
    }

}

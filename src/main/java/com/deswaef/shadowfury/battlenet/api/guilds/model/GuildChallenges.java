package com.deswaef.shadowfury.battlenet.api.guilds.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GuildChallenges extends GuildProfile {

    @SerializedName("challenge")
    private List<GuildChallenge> challenges;

    public List<GuildChallenge> getChallenges() {
        return challenges;
    }
}

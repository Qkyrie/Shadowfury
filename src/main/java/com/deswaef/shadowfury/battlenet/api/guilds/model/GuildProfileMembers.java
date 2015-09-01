package com.deswaef.shadowfury.battlenet.api.guilds.model;

import java.util.List;

public class GuildProfileMembers extends GuildProfile {
    private List<GuildMember> members;

    public List<GuildMember> getMembers() {
        return members;
    }
}

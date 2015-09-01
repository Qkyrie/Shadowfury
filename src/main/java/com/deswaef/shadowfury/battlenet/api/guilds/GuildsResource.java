package com.deswaef.shadowfury.battlenet.api.guilds;

import com.deswaef.shadowfury.battlenet.api.guilds.model.GuildNews;
import com.deswaef.shadowfury.battlenet.api.guilds.model.GuildProfile;
import com.deswaef.shadowfury.battlenet.api.guilds.model.GuildProfileMembers;
import retrofit.RestAdapter;

public class GuildsResource {
    private GuildsService guildsService;

    public GuildProfile guildProfile(String realm, String guild) {
        return guildsService.guildProfile(realm, guild);
    }

    public GuildProfileMembers guildMembers(String realm, String guild) {
        return guildsService.guildMembers(realm, guild);
    }

    public GuildNews guildNews(String realm, String guild) {
        return guildsService.guildNews(realm, guild);
    }

    public GuildsResource url(RestAdapter restAdapter) {
        this.guildsService = restAdapter.create(GuildsService.class);
        return this;
    }
}

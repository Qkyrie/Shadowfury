package com.deswaef.shadowfury.battlenet.api.guilds;

import com.deswaef.shadowfury.battlenet.api.guilds.model.GuildNews;
import com.deswaef.shadowfury.battlenet.api.guilds.model.GuildProfile;
import com.deswaef.shadowfury.battlenet.api.guilds.model.GuildProfileMembers;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by QuintenDes on 31/08/15.
 */
public interface GuildsService {

    @GET("/wow/guild/{realm}/{guild}")
    GuildProfile guildProfile(@Path("realm")String realm, @Path("guild")String guild);

    @GET("/wow/guild/{realm}/{guild}?fields=members")
    GuildProfileMembers guildMembers(@Path("realm")String realm, @Path("guild")String guild);

    @GET("/wow/guild/{realm}/{guild}?fields=news")
    GuildNews guildNews(@Path("realm")String realm, @Path("guild")String guild);
}

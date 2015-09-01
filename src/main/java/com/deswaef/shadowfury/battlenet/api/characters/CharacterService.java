package com.deswaef.shadowfury.battlenet.api.characters;

import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterAchievements;
import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterFeed;
import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterProfile;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by QuintenDes on 31/08/15.
 */
public interface CharacterService {
    @GET("/wow/character/{realm}/{name}")
    CharacterProfile characterProfile(@Path("realm")String realm, @Path("name")String name);

    @GET("/wow/character/{realm}/{name}?fields=achievements")
    CharacterAchievements characterAchievements(@Path("realm")String realm, @Path("name")String name);

    @GET("/wow/character/{realm}/{name}?fields=feed")
    CharacterFeed characterFeed(@Path("realm")String realm, @Path("name")String name);
}

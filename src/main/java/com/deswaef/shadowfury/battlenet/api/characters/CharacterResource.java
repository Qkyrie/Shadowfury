package com.deswaef.shadowfury.battlenet.api.characters;

import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterAchievements;
import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterFeed;
import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterProfile;
import retrofit.RestAdapter;

public class CharacterResource {
    private CharacterService characterService;

    public CharacterProfile characterProfile(String realm, String name) {
        return characterService.characterProfile(realm, name);
    }

    public CharacterAchievements characterAchievements(String realm, String name) {
        return characterService.characterAchievements(realm, name);
    }

    public CharacterFeed characterFeed(String realm, String name) {
        return characterService.characterFeed(realm, name);
    }

    public CharacterResource url(RestAdapter restAdapter) {
        this.characterService = restAdapter.create(CharacterService.class);
        return this;
    }
}

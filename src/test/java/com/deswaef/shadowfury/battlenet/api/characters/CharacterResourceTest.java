package com.deswaef.shadowfury.battlenet.api.characters;

import com.deswaef.shadowfury.AbstractMockedTest;
import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterAchievements;
import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterFeed;
import com.deswaef.shadowfury.battlenet.api.characters.model.CharacterProfile;
import com.deswaef.shadowfury.battlenet.configuration.ApiKeyRequestInterceptor;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class CharacterResourceTest extends AbstractMockedTest {

    private CharacterResource characterResource;

    @Before
    public void setUp() throws Exception {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://eu.api.battle.net")
                .setRequestInterceptor(new ApiKeyRequestInterceptor(apiKey()))
                .build();
        this.characterResource = new CharacterResource().url(restAdapter);
    }

    @Test
    public void ownCharHasBasicFields() throws Exception {
        CharacterProfile characterProfile = characterResource.characterProfile("silvermoon", "Pichü");
        verifyCharacterProfile(characterProfile);
    }

    @Test
    public void ownCharHasAchievementFields() throws Exception {
        CharacterAchievements characterAchievements = characterResource.characterAchievements("silvermoon", "Pichü");
        verifyCharacterProfile(characterAchievements);
        verifyCharacterAchievements(characterAchievements);
    }

    @Test
    public void ownCharHasParseableFeed() throws Exception {
        CharacterFeed characterFeed = characterResource.characterFeed("silvermoon", "Pichü");
        verifyCharacterProfile(characterFeed);
        verifyFeed(characterFeed);
    }

    private void verifyFeed(CharacterFeed characterFeed) {
        characterFeed
                .getFeed()
                .stream()
                .forEach(
                        x -> {
                            assertThat(x.getType()).isIn(CharacterFeed.CharacterFeedItem.CharacterFeedItemType.values());
                            if (x.getType().equals(CharacterFeed.CharacterFeedItem.CharacterFeedItemType.BOSSKILL)) {
                                assertThat(x.getAchievement()).isNotNull();
                            }
                        }
                );
    }

    private void verifyCharacterAchievements(CharacterAchievements characterAchievements) {
        assertThat(characterAchievements.getAchievements()).isNotNull();
        assertThat(characterAchievements.getAchievements().getAchievementsCompleted().size())
                .isEqualTo(characterAchievements.getAchievements().getAchievementsCompletedTimestamp().size())
        .isGreaterThan(0);
    }

    private void verifyCharacterProfile(CharacterProfile characterProfile) {
        assertThat(characterProfile.getAchievementPoints()).isGreaterThan(0);
        assertThat(characterProfile.getBattlegroup()).isNotEmpty();
        assertThat(characterProfile.getCalcClass()).isNotEmpty();
        assertThat(characterProfile.getClassId()).isEqualTo(9);
        assertThat(characterProfile.getGender()).isIn(0, 1);
        assertThat(characterProfile.getLevel()).isGreaterThanOrEqualTo(100);
        assertThat(characterProfile.getThumbnail()).isNotEmpty();
        assertThat(characterProfile.getTotalHonorableKills()).isGreaterThanOrEqualTo(1600);
        assertThat(characterProfile.getName()).isNotEmpty();
        assertThat(characterProfile.getRealm()).isNotEmpty();
    }
}
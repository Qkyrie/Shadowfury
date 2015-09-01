package com.deswaef.shadowfury.battlenet.api.challengemodes;

import com.deswaef.shadowfury.AbstractMockedTest;
import com.deswaef.shadowfury.battlenet.api.challengemodes.model.*;
import com.deswaef.shadowfury.battlenet.configuration.ApiKeyRequestInterceptor;
import com.deswaef.shadowfury.battlenet.configuration.OkHttpClientProvider;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class ChallengeModesResourceTest extends AbstractMockedTest {

    private ChallengeModesResource challengeModesResource;

    @Before
    public void setUp() throws Exception {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://eu.api.battle.net")
                .setClient(OkHttpClientProvider.provide())
                .setRequestInterceptor(new ApiKeyRequestInterceptor(apiKey()))
                .build();

        challengeModesResource = new ChallengeModesResource().url(restAdapter);
    }

    @Test
    public void leaderboardCanBeFetched() throws Exception {
        RealmLeaderBoard silvermoon = challengeModesResource.getRealmLeaderboard("silvermoon");
        assertThat(silvermoon).isNotNull();
        silvermoon
                .getChallenge()
                .stream()
                .forEach(
                        x -> {
                            assertThat(x.getRealm()).isNotNull();
                            assertThat(x.getMap()).isNotNull();
                            assertThat(x.getGroups()).isNotNull();
                            verify(x.getRealm());
                            verify(x.getMap());
                            verify(x.getGroups());
                        }
                );
    }

    private void verify(RealmLeaderBoardChallengeRealm realm) {
        assertThat(realm.getBattlegroup()).isNotEmpty();
        assertThat(realm.getLocale()).isNotEmpty();
        assertThat(realm.getName()).isNotEmpty();
        assertThat(realm.getSlug()).isNotEmpty();
        assertThat(realm.getTimezone()).isNotEmpty();
    }

    private void verify(RealmLeaderBoardChallengeMap map) {
        assertThat(map.getBronzeCriteria().getTime()).isGreaterThan(0);
        assertThat(map.getSilverCriteria().getTime()).isGreaterThan(0);
        assertThat(map.getGoldCriteria().getTime()).isGreaterThan(0);
    }

    private void verify(List<RealmLeaderBoardChallengeGroup> groups) {
        groups
                .stream()
                .forEach(
                        x -> {
                            assertThat(x.getDate()).isNotNull();
                            verify(x.getTime());
                            assertThat(x.getMedal()).isIn(Medal.values());
                            assertThat(x.getRanking()).isNotNull();
                            verifyMembers(x.getMembers());
                        }
                );
    }

    private void verifyMembers(List<RealmLeaderboardChallengeGroupMember> members) {
        members
                .stream()
                .forEach(
                        x -> {
                            verifyMember(x.getCharacter());
                            verifySpec(x.getSpec());
                        }
                );
    }

    private void verifySpec(RealmLeaderboardChallengeGroupMemberSpec spec) {
        assertThat(spec.getBackgroundImage()).isNotEmpty();
        assertThat(spec.getDescription()).isNotNull();
        assertThat(spec.getIcon()).isNotNull();
        assertThat(spec.getName()).isNotNull();
        assertThat(spec.getRole()).isIn(Role.values());
    }

    private void verifyMember(RealmLeaderboardChallengeGroupMemberCharacter character) {
        if (character != null) {
            assertThat(character.getBattlegroup()).isNotEmpty();
            assertThat(character.getClassId()).isGreaterThan(0);
            assertThat(character.getLevel()).isGreaterThan(0);
            assertThat(character.getRealm()).isNotEmpty();
        }
    }

    private void verify(RealmLeaderBoardChallengeGroup.Time time) {
        assertThat(time.getTime()).isNotNull();
        assertThat(time.getTime()).isGreaterThan(0);
    }
}
package com.deswaef.shadowfury.battlenet.configuration;

import com.deswaef.shadowfury.battlenet.api.auctions.AuctionResource;
import com.deswaef.shadowfury.battlenet.api.challengemodes.ChallengeModesResource;
import com.deswaef.shadowfury.battlenet.api.challengemodes.ChallengeModesService;
import com.deswaef.shadowfury.battlenet.api.characters.CharacterResource;
import com.deswaef.shadowfury.battlenet.api.characters.CharacterService;
import com.deswaef.shadowfury.battlenet.api.dataresources.DataResourcesResource;
import com.deswaef.shadowfury.battlenet.api.dataresources.DataResourcesService;
import com.deswaef.shadowfury.battlenet.api.guilds.GuildsResource;
import com.deswaef.shadowfury.battlenet.api.guilds.GuildsService;
import com.deswaef.shadowfury.battlenet.api.items.ItemResource;
import com.deswaef.shadowfury.battlenet.api.items.ItemService;
import com.deswaef.shadowfury.battlenet.api.pvp.PvpLeaderBoardResource;
import com.deswaef.shadowfury.battlenet.api.pvp.PvpLeaderboardService;
import retrofit.RestAdapter;

public class Battlenet {

    private final String baseUrl;
    private final String apiKey;
    private RestAdapter restAdapter;
    private AuctionResource auctionResource;
    private DataResourcesResource dataResourcesResource;
    private GuildsResource guildsResource;
    private ItemResource itemResource;
    private PvpLeaderBoardResource pvpLeaderBoardResource;
    private ChallengeModesResource challengeModesResource;
    private CharacterResource characterResource;

    public Battlenet(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public static Battlenet newInstance(String baseUrl, String apiKey) {
        return new Battlenet(baseUrl, apiKey)
                .url(createRestAdapter(baseUrl, apiKey))
                .auctions(new AuctionResource())
                .referencedata(new DataResourcesResource())
                .pvpleaderboard(new PvpLeaderBoardResource())
                .challengemodes(new ChallengeModesResource())
                .characters(new CharacterResource())
                .items(new ItemResource())
                .guilds(new GuildsResource());
    }

    private static RestAdapter createRestAdapter(String baseUrl, String apiKey) {
        return new RestAdapter
                .Builder()
                .setEndpoint(baseUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(OkHttpClientProvider.provide())
                .setRequestInterceptor(new ApiKeyRequestInterceptor(apiKey))
                .build();
    }

    public ChallengeModesResource challengemodes() {
        return this.challengeModesResource;
    }

    public Battlenet challengemodes(ChallengeModesResource challengeModesResource) {
        this.challengeModesResource = challengeModesResource.url(restAdapter);
        return this;
    }

    public PvpLeaderBoardResource pvpleaderboard() {
        return this.pvpLeaderBoardResource;
    }

    public Battlenet pvpleaderboard(PvpLeaderBoardResource pvpLeaderBoardResource) {
        this.pvpLeaderBoardResource = pvpLeaderBoardResource.url(restAdapter);
        return this;
    }

    public DataResourcesResource referencedata() {
        return dataResourcesResource;
    }

    public Battlenet referencedata(DataResourcesResource dataResourcesResource) {
        this.dataResourcesResource = dataResourcesResource.url(restAdapter);
        return this;
    }

    public ItemResource items() {
        return itemResource;
    }

    public Battlenet items(ItemResource itemResource) {
        this.itemResource = itemResource.url(restAdapter);
        return this;
    }

    public GuildsResource guilds() {
        return guildsResource;
    }

    public Battlenet guilds(GuildsResource guildsResource) {
        this.guildsResource = guildsResource.url(restAdapter);
        return this;
    }

    public AuctionResource auctions() {
        return auctionResource;
    }

    public CharacterResource characters() {
        return characterResource;
    }

    public Battlenet characters(CharacterResource characterResource) {
        this.characterResource = characterResource.url(restAdapter);
        return this;
    }

    public Battlenet auctions(AuctionResource auctionResource) {
        this.auctionResource = auctionResource.url(restAdapter);
        return this;
    }

    public Battlenet url(RestAdapter restAdapter){
        this.restAdapter = restAdapter;
        return this;
    }

    public RestAdapter getRestAdapter() {
        return restAdapter;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}

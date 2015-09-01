package com.deswaef.shadowfury.battlenet.api.guilds.model;

import java.util.List;

public class GuildNews extends GuildProfile {
    private List<GuildNewsItem> news;

    public List<GuildNewsItem> getNews() {
        return news;
    }
}

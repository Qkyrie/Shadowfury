package com.deswaef.shadowfury.battlenet.configuration;

public class Battlenet {
    private Battlenet() {
    }

    public static Battlenet newBattlenetInstance(
            String baseUrl,
            String clientId,
            String clientSecret,
            String redirectUrl
    ) {
        return new Battlenet();
    }

    private static RestAdapter
}

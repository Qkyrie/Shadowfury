package com.deswaef.shadowfury.battlenet.configuration;

import com.squareup.okhttp.OkHttpClient;
import retrofit.client.OkClient;

import java.util.concurrent.TimeUnit;

public class OkHttpClientProvider {
    public static OkClient provide() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        return new OkClient(okHttpClient);
    }
}

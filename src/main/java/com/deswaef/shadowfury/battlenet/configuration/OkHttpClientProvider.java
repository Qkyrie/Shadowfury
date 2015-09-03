package com.deswaef.shadowfury.battlenet.configuration;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import retrofit.client.OkClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class OkHttpClientProvider {
    public static OkClient provide() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        return new OkClient(okHttpClient);
    }

    @Bean
    public OkClient defaultProvider() {
        return provide();
    }
}

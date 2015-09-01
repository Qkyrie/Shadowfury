package com.deswaef.shadowfury.battlenet.configuration;

import retrofit.RequestInterceptor;

public class ApiKeyRequestInterceptor implements RequestInterceptor{

    private String apiKey;

    public ApiKeyRequestInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addQueryParam("apikey", apiKey);
    }
}

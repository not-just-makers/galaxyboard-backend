package com.justnotmakers.galaxyboard.ioc.provider;

import com.google.inject.Provider;
import com.justnotmakers.galaxyboard.config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;

public class ApiConfigProvider implements Provider<ApiConfig> {

    private ApiConfig apiConfig;

    public ApiConfigProvider() {
        apiConfig = ConfigFactory.create(ApiConfig.class);
    }

    @Override
    public ApiConfig get() {
        return apiConfig;
    }
}

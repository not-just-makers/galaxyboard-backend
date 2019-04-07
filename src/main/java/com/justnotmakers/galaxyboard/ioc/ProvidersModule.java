package com.justnotmakers.galaxyboard.ioc;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.justnotmakers.galaxyboard.config.ApiConfig;
import com.justnotmakers.galaxyboard.ioc.provider.ApiConfigProvider;
import com.justnotmakers.galaxyboard.ioc.provider.GsonProvider;

public class ProvidersModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ApiConfig.class).toProvider(ApiConfigProvider.class);
        bind(Gson.class).toProvider(GsonProvider.class);
    }
}

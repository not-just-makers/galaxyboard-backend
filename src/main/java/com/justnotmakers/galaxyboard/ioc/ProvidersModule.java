package com.justnotmakers.galaxyboard.ioc;

import com.github.mbelling.ws281x.LedStrip;
import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.justnotmakers.galaxyboard.config.ApiConfig;
import com.justnotmakers.galaxyboard.ioc.provider.ApiConfigProvider;
import com.justnotmakers.galaxyboard.ioc.provider.GsonProvider;
import com.justnotmakers.galaxyboard.ioc.provider.LedStripProvider;

public class ProvidersModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ApiConfig.class).toProvider(ApiConfigProvider.class);
        bind(Gson.class).toProvider(GsonProvider.class);
        bind(LedStrip.class).toProvider(LedStripProvider.class);
    }
}

package com.justnotmakers.galaxyboard.ioc.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Provider;
import io.gsonfire.DateSerializationPolicy;
import io.gsonfire.GsonFireBuilder;

public class GsonProvider implements Provider<Gson> {

    private GsonBuilder builder;

    public GsonProvider() {
        builder = new GsonFireBuilder()
            .dateSerializationPolicy(DateSerializationPolicy.rfc3339)
            .createGsonBuilder();
    }

    @Override
    public Gson get() {
        return builder.create();
    }
}

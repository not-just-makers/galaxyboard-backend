package com.justnotmakers.galaxyboard.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GalaxyboardInjector {

    private static Injector injector;

    private GalaxyboardInjector() {
    }

    public static Injector getInjector() {
        if (injector == null) {
            injector = Guice.createInjector(
                new ProvidersModule()
            );
        }
        return injector;
    }
}

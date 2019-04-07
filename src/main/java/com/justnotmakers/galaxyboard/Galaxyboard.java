package com.justnotmakers.galaxyboard;

import com.justnotmakers.galaxyboard.api.GalaxyboardApi;
import com.justnotmakers.galaxyboard.ioc.GalaxyboardInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class Galaxyboard {

    private static final Logger LOGGER = LoggerFactory.getLogger(Galaxyboard.class);

    public static void main(String[] args) throws Exception {

        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        GalaxyboardApi api = GalaxyboardInjector.getInjector().getInstance(GalaxyboardApi.class);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.info("Stopping API server");
            api.stop();
            LOGGER.info("API server stopped");
        }));

        api.start();
    }
}

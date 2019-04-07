package com.justnotmakers.galaxyboard.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ApiConfig extends Config {

    @Key("api.port")
    Integer port();

    @Key("api.rootPath")
    String rootPath();
}

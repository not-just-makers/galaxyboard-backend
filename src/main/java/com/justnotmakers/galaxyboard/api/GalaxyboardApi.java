package com.justnotmakers.galaxyboard.api;

import com.justnotmakers.galaxyboard.api.exception.ApiExceptionMapper;
import com.justnotmakers.galaxyboard.api.json.GSONProvider;
import com.justnotmakers.galaxyboard.api.resources.LedResource;
import com.justnotmakers.galaxyboard.api.resources.StatusResource;
import com.justnotmakers.galaxyboard.config.ApiConfig;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GalaxyboardApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(GalaxyboardApi.class);

    private final ApiConfig apiConfig;
    private final NettyJaxrsServer netty;

    @Inject
    public GalaxyboardApi(
        ApiConfig apiConfig,
        LedResource ledResource,
        StatusResource statusResource
    ) {
        this.apiConfig = apiConfig;
        ResteasyDeployment deployment = new ResteasyDeployment();

        List<Object> resources = new ArrayList<>();
        resources.add(ledResource);
        resources.add(statusResource);
        deployment.setResources(resources);

        List<Class> providerClasses = new ArrayList<>();
        providerClasses.add(GSONProvider.class);
        providerClasses.add(ApiExceptionMapper.class);
        deployment.setActualProviderClasses(providerClasses);

        // CORS
        CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("*");
        corsFilter.setAllowedMethods("GET, POST, PUT, DELETE, OPTIONS, HEAD");
        corsFilter.setAllowedHeaders("origin, content-type, accept, authorization");

        List<Object> providers = new ArrayList<>();
        providers.add(corsFilter);
        deployment.setProviders(providers);

        netty = new NettyJaxrsServer();
        netty.setDeployment(deployment);
        netty.setPort(apiConfig.port());
        netty.setRootResourcePath(apiConfig.rootPath());
        netty.setSecurityDomain(null);
    }

    /**
     * Starts API.
     */
    public void start() {
        LOGGER.info("Starting API");
        netty.start();
        LOGGER.info("API listening on port {}", apiConfig.port());
    }

    /**
     * Stops API.
     */
    public void stop() {
        LOGGER.info("Stopping API");
        netty.stop();
        LOGGER.info("API stopped");
    }
}

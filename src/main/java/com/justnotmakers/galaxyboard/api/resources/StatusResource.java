package com.justnotmakers.galaxyboard.api.resources;

import com.justnotmakers.galaxyboard.api.model.Status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/status")
public class StatusResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Status getStatus() {
        return Status.OK;
    }
}


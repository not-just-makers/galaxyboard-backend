package com.justnotmakers.galaxyboard.api.resources;

import com.github.mbelling.ws281x.Color;
import com.github.mbelling.ws281x.LedStrip;
import com.justnotmakers.galaxyboard.api.model.Pixel;
import com.justnotmakers.galaxyboard.api.model.Status;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/led")
public class LedResource {

    private LedStrip ledStrip;

    @Inject
    public LedResource(LedStrip ledStrip) {
        this.ledStrip = ledStrip;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Status setPixels(Pixel[] pixels) {
        ledStrip.setStrip(Color.BLACK);
        for (Pixel pixel : pixels) {
            ledStrip.setPixel(pixel.getPosition(), pixel.getColor());
        }
        ledStrip.render();
        return Status.OK;
    }
}

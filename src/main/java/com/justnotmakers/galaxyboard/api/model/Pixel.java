package com.justnotmakers.galaxyboard.api.model;

import com.github.mbelling.ws281x.Color;

public class Pixel {

    private int position;
    private Color color;

    public Pixel(int position) {
        this(position, Color.CYAN);
    }

    public Pixel(int position, Color color) {
        this.position = position;
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }
}

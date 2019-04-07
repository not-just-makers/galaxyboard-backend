package com.justnotmakers.galaxyboard.ioc.provider;

import com.github.mbelling.ws281x.LedStrip;
import com.github.mbelling.ws281x.LedStripType;
import com.github.mbelling.ws281x.Ws281xLedStrip;
import com.google.inject.Provider;

public class LedStripProvider implements Provider<LedStrip> {

    private LedStrip ledStrip;

    public LedStripProvider() {
        ledStrip = new Ws281xLedStrip(
            50,                   // Number of LED pixels.
            18,                     // GPIO pin connected to the pixels (18 uses PWM!).
            800000,               // LED signal frequency in hertz (usually 800khz)
            10,                         // DMA channel to use for generating signal (try 10)
            255,                // Set to 0 for darkest and 255 for brightest
            0,                  // Set to '1' for GPIOs 13, 19, 41, 45 or 53
            false,                  // True to invert the signal (when using NPN transistor level shift)
            LedStripType.WS2811_STRIP_RGB,
            true);
    }

    @Override
    public LedStrip get() {
        return ledStrip;
    }
}

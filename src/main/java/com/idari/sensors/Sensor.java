package com.idari.sensors;

import com.pi4j.io.gpio.Pin;

public abstract class Sensor {
    protected Pin gpioPin;

    Sensor(Pin gpioPin) {
        this.gpioPin = gpioPin;
    }
}

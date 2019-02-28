package com.idari.sensors;

import com.pi4j.io.gpio.Pin;

public class Laser extends Sensor{

    Laser(Pin gpioPin) {
        super(gpioPin);
    }
}

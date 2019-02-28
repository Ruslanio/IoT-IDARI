package com.idari.sensors;

import com.pi4j.io.gpio.Pin;

public class PaperSensor extends Sensor {
    PaperSensor(Pin gpioPin) {
        super(gpioPin);
    }
}

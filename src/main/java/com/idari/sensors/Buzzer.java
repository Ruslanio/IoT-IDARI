package com.idari.sensors;

import com.pi4j.io.gpio.Pin;

public class Buzzer extends Sensor {
    Buzzer(Pin gpioPin) {
        super(gpioPin);
    }
}

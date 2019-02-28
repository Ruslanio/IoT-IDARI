package com.idari.gpio;

import com.idari.sensors.Buzzer;
import com.idari.sensors.Laser;
import com.idari.sensors.PaperSensor;
import com.idari.sensors.Sensor;
import com.pi4j.io.gpio.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GpioPinsProvider {

    private static final Pin LASER_PIN = RaspiPin.GPIO_00;
    private static final Pin BUZZER_PIN = RaspiPin.GPIO_01;
    private static final Pin PAPER_SENSOR_PIN = RaspiPin.GPIO_02;

    private Map<Class<? extends Sensor>, Pin> availableSensors = new HashMap<Class<? extends Sensor>, Pin>();
    private GpioController gpio;

    GpioPinsProvider(GpioController gpio) {
        this.gpio = gpio;
        availableSensors.put(Buzzer.class, BUZZER_PIN);
        availableSensors.put(Laser.class, LASER_PIN);
        availableSensors.put(PaperSensor.class, PAPER_SENSOR_PIN);
    }


    public GpioPinDigitalInput provideInputPin(Class<? extends Sensor> sensorClass) {
        if (!availableSensors.containsKey(sensorClass)) {
            throw new IllegalArgumentException("Sensor class is not supported");
        }
        return gpio.provisionDigitalInputPin(availableSensors.get(sensorClass));
    }

    public GpioPinDigitalOutput provideOutputPin(Class<? extends Sensor> sensorClass) {
        if (!availableSensors.containsKey(sensorClass)) {
            throw new IllegalArgumentException("Sensor class is not supported");
        }
        return gpio.provisionDigitalOutputPin(availableSensors.get(sensorClass));
    }
}

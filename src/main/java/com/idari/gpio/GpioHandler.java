package com.idari.gpio;

import com.idari.sensors.Buzzer;
import com.idari.sensors.Laser;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinOutput;

public class GpioHandler {

    private final GpioController gpioController = GpioFactory.getInstance();
    private final GpioPinsProvider gpioPinsProvider = new GpioPinsProvider(gpioController);

    //eeeeeeeeeeeeeeeeeeeeeeeee
    public void partyHard(){
        GpioPinDigitalOutput outPinLaser = gpioPinsProvider.provideOutputPin(Laser.class);
        GpioPinDigitalOutput outPinBuzzer = gpioPinsProvider.provideOutputPin(Buzzer.class);

        while (true) {
            outPinBuzzer.toggle();
            outPinLaser.toggle();
        }
    }
}

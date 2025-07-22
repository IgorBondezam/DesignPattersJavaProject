package com.igorbondezam.designpatterns.creational.builder;

public class Director {
    
    public Car constructSportsCar(CarBuilder builder) {
        return builder
                .setEngine("V8")
                .setSeats(2)
                .setGPS(true)
                .setTripComputer(true)
                .setColor("Vermelho")
                .setTransmission("Manual")
                .build();
    }
    
    public Car constructSUV(CarBuilder builder) {
        return builder
                .setEngine("V6")
                .setSeats(7)
                .setGPS(true)
                .setTripComputer(false)
                .setColor("Preto")
                .setTransmission("Automática")
                .build();
    }
    
    public CarManual constructSportsCarManual(CarManualBuilder builder) {
        return builder
                .setEngine("V8")
                .setSeats(2)
                .setGPS(true)
                .setTripComputer(true)
                .setColor("Vermelho")
                .setTransmission("Manual")
                .build();
    }
    
    public CarManual constructSUVManual(CarManualBuilder builder) {
        return builder
                .setEngine("V6")
                .setSeats(7)
                .setGPS(true)
                .setTripComputer(false)
                .setColor("Preto")
                .setTransmission("Automática")
                .build();
    }
}


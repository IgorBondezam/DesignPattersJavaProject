package com.igorbondezam.designpatterns.creational.builder;

public class CarBuilder {
    private String engine;
    private int seats;
    private boolean hasGPS;
    private boolean hasTripComputer;
    private String color;
    private String transmission;

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public CarBuilder setGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
        return this;
    }

    public CarBuilder setTripComputer(boolean hasTripComputer) {
        this.hasTripComputer = hasTripComputer;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Car build() {
        return new Car(engine, seats, hasGPS, hasTripComputer, color, transmission);
    }
}


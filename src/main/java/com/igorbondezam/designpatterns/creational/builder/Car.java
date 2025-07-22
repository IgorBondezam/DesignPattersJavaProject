package com.igorbondezam.designpatterns.creational.builder;

public class Car {
    private String engine;
    private int seats;
    private boolean hasGPS;
    private boolean hasTripComputer;
    private String color;
    private String transmission;

    public Car(String engine, int seats, boolean hasGPS, boolean hasTripComputer, 
               String color, String transmission) {
        this.engine = engine;
        this.seats = seats;
        this.hasGPS = hasGPS;
        this.hasTripComputer = hasTripComputer;
        this.color = color;
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", seats=" + seats +
                ", hasGPS=" + hasGPS +
                ", hasTripComputer=" + hasTripComputer +
                ", color='" + color + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}


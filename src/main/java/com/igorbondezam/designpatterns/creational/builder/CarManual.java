package com.igorbondezam.designpatterns.creational.builder;

public class CarManual {
    private String engineInstructions;
    private String seatsInstructions;
    private String gpsInstructions;
    private String tripComputerInstructions;
    private String generalInstructions;

    public CarManual(String engineInstructions, String seatsInstructions, 
                     String gpsInstructions, String tripComputerInstructions,
                     String generalInstructions) {
        this.engineInstructions = engineInstructions;
        this.seatsInstructions = seatsInstructions;
        this.gpsInstructions = gpsInstructions;
        this.tripComputerInstructions = tripComputerInstructions;
        this.generalInstructions = generalInstructions;
    }

    public void print() {
        System.out.println("=== MANUAL DO CARRO ===");
        System.out.println("Instruções gerais: " + generalInstructions);
        System.out.println("Motor: " + engineInstructions);
        System.out.println("Assentos: " + seatsInstructions);
        if (gpsInstructions != null) {
            System.out.println("GPS: " + gpsInstructions);
        }
        if (tripComputerInstructions != null) {
            System.out.println("Computador de bordo: " + tripComputerInstructions);
        }
    }
}


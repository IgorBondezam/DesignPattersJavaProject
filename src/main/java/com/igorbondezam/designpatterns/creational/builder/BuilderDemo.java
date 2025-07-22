package com.igorbondezam.designpatterns.creational.builder;

import com.igorbondezam.utils.CmdVisualUtils;

public class BuilderDemo {
    
    public static void demonstrate() {
        System.out.println("=== BUILDER PATTERN ===");
        System.out.println("Problema: Construir objetos complexos passo a passo");
        System.out.println("Solução: Separar a construção de um objeto de sua representação\n");
        
        Director director = new Director();
        
        // Construindo um carro esportivo
        System.out.println("Construindo carro esportivo:");
        CarBuilder carBuilder = new CarBuilder();
        Car sportsCar = director.constructSportsCar(carBuilder);
        System.out.println(sportsCar);
        
        // Construindo manual do carro esportivo
        CarManualBuilder manualBuilder = new CarManualBuilder();
        CarManual sportsCarManual = director.constructSportsCarManual(manualBuilder);
        sportsCarManual.print();

        CmdVisualUtils.separetorCmd(50);

        // Construindo um SUV
        System.out.println("Construindo SUV:");
        CarBuilder suvBuilder = new CarBuilder();
        Car suv = director.constructSUV(suvBuilder);
        System.out.println(suv);
        
        // Construindo manual do SUV
        CarManualBuilder suvManualBuilder = new CarManualBuilder();
        CarManual suvManual = director.constructSUVManual(suvManualBuilder);
        suvManual.print();

        CmdVisualUtils.separetorCmd(50);

        // Construção personalizada sem Director
        System.out.println("Construção personalizada:");
        Car customCar = new CarBuilder()
                .setEngine("V4")
                .setSeats(4)
                .setGPS(false)
                .setTripComputer(true)
                .setColor("Azul")
                .setTransmission("CVT")
                .build();
        System.out.println(customCar);
        
        System.out.println("\nVantagens:");
        System.out.println("- Permite construir objetos passo a passo");
        System.out.println("- Permite reutilizar o mesmo código de construção");
        System.out.println("- Isola código complexo de construção da lógica de negócio");
        System.out.println("- Permite criar diferentes representações do mesmo objeto");
    }
}


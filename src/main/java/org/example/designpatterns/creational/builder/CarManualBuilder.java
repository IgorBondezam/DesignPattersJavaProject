package org.example.designpatterns.creational.builder;

public class CarManualBuilder {
    private String engineInstructions;
    private String seatsInstructions;
    private String gpsInstructions;
    private String tripComputerInstructions;
    private String generalInstructions;

    public CarManualBuilder setEngine(String engine) {
        this.engineInstructions = "Instruções para motor " + engine + ": Verificar óleo regularmente.";
        return this;
    }

    public CarManualBuilder setSeats(int seats) {
        this.seatsInstructions = "Instruções para " + seats + " assentos: Ajustar posição antes de dirigir.";
        return this;
    }

    public CarManualBuilder setGPS(boolean hasGPS) {
        if (hasGPS) {
            this.gpsInstructions = "Instruções GPS: Atualizar mapas mensalmente.";
        }
        return this;
    }

    public CarManualBuilder setTripComputer(boolean hasTripComputer) {
        if (hasTripComputer) {
            this.tripComputerInstructions = "Instruções computador de bordo: Resetar após cada viagem.";
        }
        return this;
    }

    public CarManualBuilder setColor(String color) {
        this.generalInstructions = "Carro na cor " + color + ". Lavar regularmente para manter a cor.";
        return this;
    }

    public CarManualBuilder setTransmission(String transmission) {
        // Adiciona informações sobre transmissão às instruções gerais
        if (generalInstructions == null) {
            generalInstructions = "";
        }
        generalInstructions += " Transmissão " + transmission + ".";
        return this;
    }

    public CarManual build() {
        return new CarManual(engineInstructions, seatsInstructions, 
                           gpsInstructions, tripComputerInstructions, generalInstructions);
    }
}


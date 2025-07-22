package org.example.designpatterns.behavioral.command;

public class Stereo {
    private boolean isOn = false;
    private int volume = 0;
    private String location;

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        isOn = true;
        System.out.println("Som da " + location + " está LIGADO");
    }

    public void off() {
        isOn = false;
        System.out.println("Som da " + location + " está DESLIGADO");
    }

    public void setCd() {
        System.out.println("Som da " + location + " configurado para CD");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume do som da " + location + " ajustado para " + volume);
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return isOn;
    }
}


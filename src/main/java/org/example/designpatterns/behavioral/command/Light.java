package org.example.designpatterns.behavioral.command;

public class Light {
    private boolean isOn = false;
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        isOn = true;
        System.out.println("Luz da " + location + " está LIGADA");
    }

    public void off() {
        isOn = false;
        System.out.println("Luz da " + location + " está DESLIGADA");
    }

    public boolean isOn() {
        return isOn;
    }
}


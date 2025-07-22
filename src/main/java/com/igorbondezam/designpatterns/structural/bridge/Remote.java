package com.igorbondezam.designpatterns.structural.bridge;

public class Remote {
    protected Device device;

    public Remote() {}

    public Remote(Device device) {
        this.device = device;
    }

    public void togglePower() {
        System.out.println("Controle remoto: alternando energia");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void volumeDown() {
        System.out.println("Controle remoto: diminuindo volume");
        device.setVolume(device.getVolume() - 10);
    }

    public void volumeUp() {
        System.out.println("Controle remoto: aumentando volume");
        device.setVolume(device.getVolume() + 10);
    }

    public void channelDown() {
        System.out.println("Controle remoto: canal anterior");
        device.setChannel(device.getChannel() - 1);
    }

    public void channelUp() {
        System.out.println("Controle remoto: próximo canal");
        device.setChannel(device.getChannel() + 1);
    }
}


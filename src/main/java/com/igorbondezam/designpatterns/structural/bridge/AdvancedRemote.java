package com.igorbondezam.designpatterns.structural.bridge;

public class AdvancedRemote extends Remote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Controle remoto avançado: mudo");
        device.setVolume(0);
    }
    
    public void setVolume(int volume) {
        System.out.println("Controle remoto avançado: definindo volume para " + volume);
        device.setVolume(volume);
    }
    
    public void setChannel(int channel) {
        System.out.println("Controle remoto avançado: mudando para canal " + channel);
        device.setChannel(channel);
    }
}


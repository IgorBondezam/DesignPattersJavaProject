package com.igorbondezam.designpatterns.structural.bridge;

import com.igorbondezam.utils.CmdVisualUtils;

public class BridgeDemo {
    
    public static void demonstrate() {
        System.out.println("=== BRIDGE PATTERN ===");
        System.out.println("Problema: Evitar ligação permanente entre abstração e implementação");
        System.out.println("Solução: Separar abstração de implementação para que ambas possam variar independentemente\n");
        
        System.out.println("Teste 1: Controle remoto básico com TV");
        testDevice(new Tv());
        
        System.out.println("Teste 2: Controle remoto básico com Rádio");
        testDevice(new Radio());
        
        System.out.println("Teste 3: Controle remoto avançado com TV");
        testAdvancedRemote(new Tv());
        
        System.out.println("Teste 4: Controle remoto avançado com Rádio");
        testAdvancedRemote(new Radio());
        
        System.out.println("Vantagens:");
        System.out.println("- Desacopla abstração de implementação");
        System.out.println("- Permite extensão independente de abstrações e implementações");
        System.out.println("- Esconde detalhes de implementação do cliente");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Permite trocar implementações em tempo de execução");
    }
    
    public static void testDevice(Device device) {
        System.out.println("Testes com controle remoto básico:");
        Remote basicRemote = new Remote(device);
        basicRemote.togglePower();
        device.printStatus();
        
        basicRemote.volumeUp();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        device.printStatus();

        CmdVisualUtils.separetorCmd(50);
    }
    
    public static void testAdvancedRemote(Device device) {
        System.out.println("Testes com controle remoto avançado:");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.togglePower();
        advancedRemote.setVolume(75);
        advancedRemote.setChannel(5);
        device.printStatus();
        
        advancedRemote.mute();
        device.printStatus();

        CmdVisualUtils.separetorCmd(50);
    }
}


package org.example.designpatterns.behavioral.command;

public class CommandDemo {
    
    public static void demonstrate() {
        System.out.println("=== COMMAND PATTERN ===");
        System.out.println("Problema: Transformar requisições em objetos independentes");
        System.out.println("Solução: Encapsular requisições como objetos, permitindo parametrizar clientes\n");
        
        // Criando o controle remoto
        RemoteControl remoteControl = new RemoteControl();
        
        // Criando dispositivos
        Light livingRoomLight = new Light("sala");
        Light kitchenLight = new Light("cozinha");
        Stereo stereo = new Stereo("sala");
        
        // Criando comandos
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        Command stereoOff = new Command() {
            @Override
            public void execute() {
                stereo.off();
            }
            
            @Override
            public void undo() {
                stereo.on();
                stereo.setCd();
                stereo.setVolume(11);
            }
        };
        
        // Configurando o controle remoto
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);
        
        System.out.println(remoteControl);
        
        System.out.println("Testando comandos:");
        
        // Testando luz da sala
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println();
        
        // Testando luz da cozinha
        remoteControl.onButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
        System.out.println();
        
        // Testando som
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();
        System.out.println();
        
        // Testando múltiplos undos
        System.out.println("Testando múltiplos comandos e undos:");
        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        System.out.println();
        
        System.out.println("Desfazendo comandos:");
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed(); // Não há mais comandos
        
        System.out.println("\nVantagens:");
        System.out.println("- Desacopla objeto que invoca operação do objeto que a executa");
        System.out.println("- Permite parametrizar objetos com diferentes requisições");
        System.out.println("- Permite enfileirar operações, agendar execução e fazer log");
        System.out.println("- Suporta operações de desfazer");
        System.out.println("- Permite compor comandos complexos a partir de comandos simples");
    }
}


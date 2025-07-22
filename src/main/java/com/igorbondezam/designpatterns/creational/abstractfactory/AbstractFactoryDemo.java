package com.igorbondezam.designpatterns.creational.abstractfactory;

public class AbstractFactoryDemo {
    
    public static void demonstrate() {
        System.out.println("=== ABSTRACT FACTORY PATTERN ===");
        System.out.println("Problema: Criar famílias de objetos relacionados sem especificar suas classes concretas");
        System.out.println("Solução: Fornecer uma interface para criar famílias de objetos relacionados\n");
        
        // Configurar aplicação para Windows
        System.out.println("Configurando aplicação para Windows:");
        GUIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);
        windowsApp.paint();
        
        System.out.println("\nConfigurando aplicação para Mac:");
        GUIFactory macFactory = new MacFactory();
        Application macApp = new Application(macFactory);
        macApp.paint();
        
        System.out.println("\nVantagens:");
        System.out.println("- Garante compatibilidade entre produtos de uma família");
        System.out.println("- Evita acoplamento entre código cliente e produtos concretos");
        System.out.println("- Segue o princípio Single Responsibility");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Facilita troca de famílias de produtos inteiras");
    }
}


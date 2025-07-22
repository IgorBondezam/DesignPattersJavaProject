package com.igorbondezam.designpatterns.behavioral.chainofresponsibility;

import com.igorbondezam.utils.CmdVisualUtils;

public class ChainOfResponsibilityDemo {
    
    public static void demonstrate() {
        System.out.println("=== CHAIN OF RESPONSIBILITY PATTERN ===");
        System.out.println("Problema: Passar requisições ao longo de uma cadeia de handlers");
        System.out.println("Solução: Permitir que múltiplos objetos tenham chance de tratar a requisição\n");
        
        // Construindo a cadeia
        Handler monkey = new MonkeyHandler();
        Handler squirrel = new SquirrelHandler();
        Handler dog = new DogHandler();
        
        monkey.setNext(squirrel);
        squirrel.setNext(dog);
        
        System.out.println("Cadeia construída: Macaco -> Esquilo -> Cachorro\n");
        
        // Testando diferentes alimentos
        String[] foods = {"Noz", "Banana", "Carne", "Café"};
        
        for (String food : foods) {
            System.out.println("Cliente: Quem quer " + food + "?");
            boolean result = monkey.handle(food);
            if (!result) {
                System.out.println("Ninguém quis a " + food + ".");
            }
            System.out.println();
        }

        CmdVisualUtils.separetorCmd(50);

        // Testando cadeia diferente
        System.out.println("Testando cadeia diferente: Cachorro -> Macaco");
        dog.setNext(monkey);
        squirrel.setNext(null); // Remove esquilo da cadeia
        
        System.out.println("\nCliente: Quem quer Banana?");
        dog.handle("Banana");
        
        System.out.println("\nVantagens:");
        System.out.println("- Desacopla remetente de destinatários");
        System.out.println("- Permite adicionar ou remover handlers dinamicamente");
        System.out.println("- Segue o princípio Single Responsibility");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Permite controlar ordem de processamento");
    }
}


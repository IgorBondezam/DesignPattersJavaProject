package org.example.designpatterns.behavioral.iterator;

import org.example.utils.CmdVisualUtils;

import java.util.ArrayList;
import java.util.List;

public class IteratorDemo {
    
    public static void demonstrate() {
        System.out.println("=== ITERATOR PATTERN ===");
        System.out.println("Problema: Percorrer elementos de uma coleção sem expor sua representação");
        System.out.println("Solução: Extrair comportamento de travessia para um objeto iterador separado\n");
        
        // Criando perfis de exemplo
        List<Profile> profiles = new ArrayList<>();
        
        Profile anna = new Profile("anna.smith@example.com", "Anna Smith");
        anna.addContact("john.doe@example.com");
        anna.addContact("mary.jane@example.com");
        profiles.add(anna);
        
        Profile john = new Profile("john.doe@example.com", "John Doe");
        john.addContact("anna.smith@example.com");
        john.addContact("bob.wilson@example.com");
        profiles.add(john);
        
        Profile mary = new Profile("mary.jane@example.com", "Mary Jane");
        mary.addContact("anna.smith@example.com");
        profiles.add(mary);
        
        Profile bob = new Profile("bob.wilson@example.com", "Bob Wilson");
        bob.addContact("john.doe@example.com");
        profiles.add(bob);
        
        // Criando rede social
        SocialNetwork network = new Facebook(profiles);
        SocialSpammer spammer = new SocialSpammer(network);
        
        System.out.println("Teste 1: Enviando mensagem para amigos");
        spammer.sendSpamToFriends("anna.smith@example.com", 
                                 "Olá! Confira meu novo projeto!");

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 2: Enviando mensagem para colegas de trabalho");
        spammer.sendSpamToCoworkers("john.doe@example.com", 
                                   "Reunião de equipe amanhã às 10h");

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 3: Demonstrando lazy loading");
        System.out.println("Criando iterador...");
        ProfileIterator iterator = network.createFriendsIterator("anna.smith@example.com");
        
        System.out.println("Verificando se há próximo elemento...");
        if (iterator.hasNext()) {
            System.out.println("Obtendo primeiro perfil...");
            Profile firstFriend = iterator.getNext();
            System.out.println("Primeiro amigo: " + firstFriend.getName());
        }
        
        System.out.println("\nVantagens:");
        System.out.println("- Simplifica interface da coleção");
        System.out.println("- Suporta múltiplas travessias simultâneas");
        System.out.println("- Permite implementar diferentes algoritmos de travessia");
        System.out.println("- Segue o princípio Single Responsibility");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Permite travessia lazy (sob demanda)");
    }
}


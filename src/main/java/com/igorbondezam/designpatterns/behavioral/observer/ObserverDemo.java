package com.igorbondezam.designpatterns.behavioral.observer;

import com.igorbondezam.utils.CmdVisualUtils;

public class ObserverDemo {
    
    public static void demonstrate() {
        System.out.println("=== OBSERVER PATTERN ===");
        System.out.println("Problema: Notificar múltiplos objetos sobre mudanças em outro objeto");
        System.out.println("Solução: Definir mecanismo de assinatura para notificar múltiplos objetos\n");
        
        Editor editor = new Editor();
        
        // Criando listeners
        EmailNotificationListener emailListener = new EmailNotificationListener("admin@example.com");
        LogOpenListener logListener = new LogOpenListener("/path/to/log/file.txt");
        
        // Inscrevendo listeners
        System.out.println("Configurando observadores:");
        editor.events.subscribe("open", logListener);
        editor.events.subscribe("open", emailListener);
        editor.events.subscribe("save", emailListener);

        CmdVisualUtils.separetorCmd(50);

        // Testando eventos
        System.out.println("Teste 1: Abrindo arquivo");
        editor.openFile("/home/user/document.txt");

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 2: Salvando arquivo");
        try {
            editor.saveFile();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 3: Removendo observador e testando novamente");
        editor.events.unsubscribe("open", emailListener);
        
        System.out.println("\nAbrindo outro arquivo:");
        editor.openFile("/home/user/another_document.txt");

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 4: Adicionando novo observador");
        EventListener consoleListener = new EventListener() {
            @Override
            public void update(String eventType, String data) {
                System.out.println("Console: Evento " + eventType + " detectado para arquivo " + data);
            }
        };
        
        editor.events.subscribe("save", consoleListener);
        
        System.out.println("\nSalvando arquivo com novo observador:");
        try {
            editor.saveFile();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        System.out.println("\nVantagens:");
        System.out.println("- Estabelece relações dinâmicas entre objetos");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Permite adicionar/remover observadores em tempo de execução");
        System.out.println("- Desacopla publicador de assinantes concretos");
        System.out.println("- Suporta comunicação broadcast");
    }
}


package com.igorbondezam.designpatterns.creational.singleton;

import com.igorbondezam.utils.CmdVisualUtils;

public class SingletonDemo {
    
    public static void demonstrate() {
        System.out.println("=== SINGLETON PATTERN ===");
        System.out.println("Problema: Garantir que uma classe tenha apenas uma instância");
        System.out.println("Solução: Controlar a criação de instâncias através de um método estático\n");
        
        // Teste básico do Singleton
        System.out.println("Teste 1: Criando instâncias do Singleton");
        Singleton singleton1 = Singleton.getInstance("Primeira instância");
        Singleton singleton2 = Singleton.getInstance("Segunda instância");
        
        System.out.println("Valor da primeira instância: " + singleton1.getValue());
        System.out.println("Valor da segunda instância: " + singleton2.getValue());
        
        if (singleton1 == singleton2) {
            System.out.println("✓ Ambas as variáveis referenciam a mesma instância");
        } else {
            System.out.println("✗ Instâncias diferentes (erro no Singleton)");
        }

        CmdVisualUtils.separetorCmd(50);

        // Teste com exemplo prático - DatabaseConnection
        System.out.println("Teste 2: Exemplo prático - Conexão com Banco de Dados");
        
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        if (db1 == db2) {
            System.out.println("✓ Mesma instância de conexão obtida");
        }
        
        db1.connect();
        db2.executeQuery("SELECT * FROM users");
        
        // Testando que db2 também está conectado (mesma instância)
        System.out.println("Status da conexão db2: " + (db2.isConnected() ? "Conectado" : "Desconectado"));
        
        db1.disconnect();
        System.out.println("Status da conexão db2 após db1.disconnect(): " + (db2.isConnected() ? "Conectado" : "Desconectado"));

        CmdVisualUtils.separetorCmd(50);

        // Teste de thread safety
        System.out.println("Teste 3: Thread Safety");
        Thread thread1 = new Thread(() -> {
            Singleton s = Singleton.getInstance("Thread 1");
            System.out.println("Thread 1 obteve instância: " + s.hashCode());
        });
        
        Thread thread2 = new Thread(() -> {
            Singleton s = Singleton.getInstance("Thread 2");
            System.out.println("Thread 2 obteve instância: " + s.hashCode());
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nVantagens:");
        System.out.println("- Garante que uma classe tenha apenas uma instância");
        System.out.println("- Fornece ponto de acesso global a essa instância");
        System.out.println("- Inicialização lazy (só cria quando necessário)");
        System.out.println("- Controla recursos compartilhados (ex: conexões de banco)");
        
        System.out.println("\nDesvantagens:");
        System.out.println("- Viola o princípio Single Responsibility");
        System.out.println("- Pode mascarar design ruim");
        System.out.println("- Requer tratamento especial em ambientes multi-thread");
        System.out.println("- Dificulta testes unitários");
    }
}


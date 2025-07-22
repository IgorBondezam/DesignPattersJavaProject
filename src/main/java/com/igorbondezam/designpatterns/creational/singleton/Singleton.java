package com.igorbondezam.designpatterns.creational.singleton;

public class Singleton {
    // Instância única da classe (thread-safe)
    private static volatile Singleton instance;
    
    // Dados da instância
    private String value;
    
    // Construtor privado para prevenir instanciação externa
    private Singleton(String value) {
        this.value = value;
        // Simular algum trabalho de inicialização
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    // Método thread-safe para obter a instância (Double-checked locking)
    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public void doSomething() {
        System.out.println("Executando operação no Singleton com valor: " + value);
    }
}


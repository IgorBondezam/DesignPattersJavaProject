package org.example.designpatterns.creational.singleton;

public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private String connectionString;
    private boolean isConnected;
    
    private DatabaseConnection() {
        // Simular configuração de conexão
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        this.isConnected = false;
        System.out.println("Configurando conexão com banco de dados...");
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    public void connect() {
        if (!isConnected) {
            System.out.println("Conectando ao banco: " + connectionString);
            isConnected = true;
        } else {
            System.out.println("Já conectado ao banco de dados");
        }
    }
    
    public void disconnect() {
        if (isConnected) {
            System.out.println("Desconectando do banco de dados");
            isConnected = false;
        } else {
            System.out.println("Já desconectado do banco de dados");
        }
    }
    
    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("Executando query: " + query);
        } else {
            System.out.println("Erro: Não conectado ao banco de dados");
        }
    }
    
    public boolean isConnected() {
        return isConnected;
    }
}


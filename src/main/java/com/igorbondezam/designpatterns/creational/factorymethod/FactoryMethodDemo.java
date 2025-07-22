package com.igorbondezam.designpatterns.creational.factorymethod;

public class FactoryMethodDemo {
    
    public static void demonstrate() {
        System.out.println("=== FACTORY METHOD PATTERN ===");
        System.out.println("Problema: Criar objetos sem especificar suas classes concretas");
        System.out.println("Solução: Delegar a criação para subclasses através de um método factory\n");
        
        // Simular detecção do sistema operacional
        String osName = System.getProperty("os.name").toLowerCase();
        Dialog dialog;
        
        if (osName.contains("mac")) {
            dialog = new MacDialog();
            System.out.println("Sistema Mac detectado - usando MacDialog");
        } else {
            dialog = new WindowsDialog();
            System.out.println("Sistema Windows detectado - usando WindowsDialog");
        }
        
        System.out.println("\nRenderizando janela:");
        dialog.renderWindow();
        
        System.out.println("\n--- Testando ambos os tipos ---");
        
        System.out.println("\nTeste Windows Dialog:");
        Dialog windowsDialog = new WindowsDialog();
        windowsDialog.renderWindow();
        
        System.out.println("\nTeste Mac Dialog:");
        Dialog macDialog = new MacDialog();
        macDialog.renderWindow();
        
        System.out.println("\nVantagens:");
        System.out.println("- Evita acoplamento entre criador e produtos concretos");
        System.out.println("- Segue o princípio Single Responsibility");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Facilita adição de novos tipos de produtos");
    }
}


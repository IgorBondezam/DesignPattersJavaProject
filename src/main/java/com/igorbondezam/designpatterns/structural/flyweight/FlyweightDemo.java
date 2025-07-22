package com.igorbondezam.designpatterns.structural.flyweight;

import com.igorbondezam.utils.CmdVisualUtils;

import java.awt.Color;
import java.util.Random;

public class FlyweightDemo {
    
    public static void demonstrate() {
        System.out.println("=== FLYWEIGHT PATTERN ===");
        System.out.println("Problema: Suportar grandes quantidades de objetos similares eficientemente");
        System.out.println("Solução: Compartilhar eficientemente partes comuns do estado entre múltiplos objetos\n");
        
        Forest forest = new Forest();
        Random random = new Random();
        
        System.out.println("Plantando floresta com diferentes tipos de árvores...\n");
        
        // Plantar muitas árvores de poucos tipos
        for (int i = 0; i < 10; i++) {
            forest.plantTree(
                random.nextInt(100), 
                random.nextInt(100),
                "Carvalho", 
                Color.GREEN, 
                "🌳"
            );
        }
        
        for (int i = 0; i < 8; i++) {
            forest.plantTree(
                random.nextInt(100), 
                random.nextInt(100),
                "Pinheiro", 
                Color.DARK_GRAY, 
                "🌲"
            );
        }
        
        for (int i = 0; i < 5; i++) {
            forest.plantTree(
                random.nextInt(100), 
                random.nextInt(100),
                "Cerejeira", 
                Color.PINK, 
                "🌸"
            );
        }
        
        for (int i = 0; i < 7; i++) {
            forest.plantTree(
                random.nextInt(100), 
                random.nextInt(100),
                "Carvalho", 
                Color.GREEN, 
                "🌳"
            );
        }
        
        System.out.println("\nEstatísticas da floresta:");
        System.out.println("Total de árvores plantadas: " + forest.getTreeCount());
        System.out.println("Tipos de árvore únicos criados: " + TreeTypeFactory.getCreatedTreeTypesCount());
        System.out.println("Economia de memória: " + (forest.getTreeCount() - TreeTypeFactory.getCreatedTreeTypesCount()) + " objetos compartilhados");

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Renderizando floresta (primeiras 5 árvores):");
        // Simular renderização das primeiras árvores
        forest.render(null);

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Adicionando mais árvores do mesmo tipo...");
        for (int i = 0; i < 15; i++) {
            forest.plantTree(
                random.nextInt(100), 
                random.nextInt(100),
                "Carvalho", 
                Color.GREEN, 
                "🌳"
            );
        }
        
        System.out.println("\nEstatísticas finais:");
        System.out.println("Total de árvores: " + forest.getTreeCount());
        System.out.println("Tipos únicos: " + TreeTypeFactory.getCreatedTreeTypesCount());
        System.out.println("Objetos flyweight reutilizados: " + (forest.getTreeCount() - TreeTypeFactory.getCreatedTreeTypesCount()));
        
        // Demonstrar economia de memória
        long memoryWithoutFlyweight = forest.getTreeCount() * 1000; // Simula 1KB por árvore
        long memoryWithFlyweight = TreeTypeFactory.getCreatedTreeTypesCount() * 1000 + forest.getTreeCount() * 100; // 1KB por tipo + 100B por contexto
        
        System.out.println("\nEconomia de memória simulada:");
        System.out.println("Sem Flyweight: " + memoryWithoutFlyweight + " bytes");
        System.out.println("Com Flyweight: " + memoryWithFlyweight + " bytes");
        System.out.println("Economia: " + (memoryWithoutFlyweight - memoryWithFlyweight) + " bytes (" + 
                          String.format("%.1f", ((double)(memoryWithoutFlyweight - memoryWithFlyweight) / memoryWithoutFlyweight) * 100) + "%)");
        
        System.out.println("\nVantagens:");
        System.out.println("- Economiza RAM quando há muitos objetos similares");
        System.out.println("- Centraliza estado compartilhado em poucos objetos flyweight");
        System.out.println("- Reduz número total de objetos na aplicação");
        System.out.println("- Melhora performance em aplicações com muitos objetos");
    }
}


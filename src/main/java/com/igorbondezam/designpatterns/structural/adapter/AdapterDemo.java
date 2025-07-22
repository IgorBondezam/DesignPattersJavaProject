package com.igorbondezam.designpatterns.structural.adapter;

import com.igorbondezam.utils.CmdVisualUtils;

public class AdapterDemo {
    
    public static void demonstrate() {
        System.out.println("=== ADAPTER PATTERN ===");
        System.out.println("Problema: Fazer classes incompatíveis trabalharem juntas");
        System.out.println("Solução: Criar um adaptador que converte a interface de uma classe\n");
        
        // Buraco redondo com raio 5
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        
        System.out.println("Teste 1: Pino redondo em buraco redondo");
        System.out.println("Buraco redondo (raio 5) + Pino redondo (raio 5)");
        if (hole.fits(rpeg)) {
            System.out.println("✓ Pino redondo encaixa no buraco redondo");
        } else {
            System.out.println("✗ Pino redondo NÃO encaixa no buraco redondo");
        }
        
        CmdVisualUtils.separetorCmd(50);

        
        // Pinos quadrados de diferentes tamanhos
        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        
        System.out.println("Teste 2: Tentativa direta (sem adapter)");
        System.out.println("Pinos quadrados não podem ser testados diretamente no buraco redondo");
        System.out.println("- Pino quadrado pequeno (largura 2)");
        System.out.println("- Pino quadrado grande (largura 20)");
        
        // hole.fits(smallSqPeg); // Isso não compilaria!
        
        CmdVisualUtils.separetorCmd(50);

        
        System.out.println("Teste 3: Usando Adapter");
        
        // Adaptadores para os pinos quadrados
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        
        System.out.println("Pino quadrado pequeno (largura 2):");
        System.out.println("  Raio equivalente calculado: " + String.format("%.2f", smallSqPegAdapter.getRadius()));
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("  ✓ Pino quadrado pequeno encaixa no buraco redondo");
        } else {
            System.out.println("  ✗ Pino quadrado pequeno NÃO encaixa no buraco redondo");
        }
        
        System.out.println("\nPino quadrado grande (largura 20):");
        System.out.println("  Raio equivalente calculado: " + String.format("%.2f", largeSqPegAdapter.getRadius()));
        if (hole.fits(largeSqPegAdapter)) {
            System.out.println("  ✓ Pino quadrado grande encaixa no buraco redondo");
        } else {
            System.out.println("  ✗ Pino quadrado grande NÃO encaixa no buraco redondo");
        }
        
        CmdVisualUtils.separetorCmd(50);

        
        System.out.println("Teste 4: Diferentes tamanhos de buracos");
        RoundHole bigHole = new RoundHole(15);
        
        System.out.println("Buraco grande (raio 15) + Pino quadrado grande (largura 20):");
        if (bigHole.fits(largeSqPegAdapter)) {
            System.out.println("✓ Pino quadrado grande encaixa no buraco grande");
        } else {
            System.out.println("✗ Pino quadrado grande NÃO encaixa no buraco grande");
        }
        
        System.out.println("\nVantagens:");
        System.out.println("- Separa a lógica de conversão da lógica de negócio");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Permite reutilizar código existente incompatível");
        System.out.println("- Não modifica o código da regra nem o código adaptado");
    }
}


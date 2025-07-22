package com.igorbondezam.designpatterns.structural.composite;

import com.igorbondezam.utils.CmdVisualUtils;

public class CompositeDemo {
    
    public static void demonstrate() {
        System.out.println("=== COMPOSITE PATTERN ===");
        System.out.println("Problema: Trabalhar com estruturas de árvore de objetos de forma uniforme");
        System.out.println("Solução: Compor objetos em estruturas de árvore e trabalhar com eles através de interface comum\n");
        
        System.out.println("Teste 1: Criando elementos gráficos individuais");
        Dot dot1 = new Dot(10, 15);
        Dot dot2 = new Dot(20, 25);
        Circle circle1 = new Circle(5, 10, 8);
        Circle circle2 = new Circle(15, 20, 12);
        
        dot1.draw();
        dot2.draw();
        circle1.draw();
        circle2.draw();

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 2: Criando grupo composto");
        CompoundGraphic group1 = new CompoundGraphic();
        group1.add(dot1);
        group1.add(circle1);
        
        System.out.println("Grupo 1:");
        group1.draw();

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 3: Criando grupo aninhado");
        CompoundGraphic group2 = new CompoundGraphic();
        group2.add(dot2);
        group2.add(circle2);
        
        CompoundGraphic allGraphics = new CompoundGraphic();
        allGraphics.add(group1);
        allGraphics.add(group2);
        
        System.out.println("Todos os gráficos (grupos aninhados):");
        allGraphics.draw();

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 4: Movendo grupo inteiro");
        System.out.println("Movendo todos os gráficos em (5, 5)...");
        allGraphics.move(5, 5);
        
        System.out.println("Estado após movimento:");
        allGraphics.draw();

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 5: Editor de imagem");
        ImageEditor editor = new ImageEditor();
        editor.load();
        
        System.out.println("Conteúdo inicial do editor:");
        editor.draw();
        
        System.out.println("\nVantagens:");
        System.out.println("- Trabalha com estruturas de árvore complexas mais facilmente");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Permite tratar objetos individuais e composições uniformemente");
        System.out.println("- Simplifica o código cliente");
    }
}


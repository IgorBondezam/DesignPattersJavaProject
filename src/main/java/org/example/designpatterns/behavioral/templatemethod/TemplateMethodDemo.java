package org.example.designpatterns.behavioral.templatemethod;

import org.example.utils.CmdVisualUtils;

public class TemplateMethodDemo {
    
    public static void demonstrate() {
        System.out.println("=== TEMPLATE METHOD PATTERN ===");
        System.out.println("Problema: Definir esqueleto de algoritmo permitindo que subclasses sobrescrevam etapas");
        System.out.println("Solução: Definir estrutura do algoritmo na superclasse, deixando detalhes para subclasses\n");
        
        System.out.println("Teste 1: Mineração de dados PDF");
        DataMiner pdfMiner = new PDFDataMiner();
        pdfMiner.mineData("documento.pdf");

        CmdVisualUtils.separetorCmd(60);

        System.out.println("Teste 2: Mineração de dados CSV");
        DataMiner csvMiner = new CSVDataMiner();
        csvMiner.mineData("planilha.csv");

        CmdVisualUtils.separetorCmd(60);

        System.out.println("Teste 3: Mineração de dados DOC (com comportamento customizado)");
        DataMiner docMiner = new DocDataMiner();
        docMiner.mineData("relatorio.doc");

        CmdVisualUtils.separetorCmd(60);

        System.out.println("Demonstração: Mesmo algoritmo, implementações diferentes");
        System.out.println("Todos os mineradores seguem os mesmos passos:");
        System.out.println("1. Abrir arquivo");
        System.out.println("2. Extrair dados (implementação específica)");
        System.out.println("3. Parsear dados (implementação específica)");
        System.out.println("4. Analisar dados (comportamento padrão)");
        System.out.println("5. Enviar relatório (comportamento padrão ou customizado)");
        System.out.println("6. Fechar arquivo");
        
        System.out.println("\nVantagens:");
        System.out.println("- Permite reutilizar código comum entre classes similares");
        System.out.println("- Permite que subclasses sobrescrevam apenas partes específicas");
        System.out.println("- Controla pontos de extensão através de hooks");
        System.out.println("- Segue o princípio Don't Repeat Yourself (DRY)");
        System.out.println("- Facilita manutenção do algoritmo principal");
    }
}


package com.igorbondezam.designpatterns.structural.decorator;

import com.igorbondezam.utils.CmdVisualUtils;

public class DecoratorDemo {
    
    public static void demonstrate() {
        System.out.println("=== DECORATOR PATTERN ===");
        System.out.println("Problema: Adicionar comportamentos a objetos sem alterar sua estrutura");
        System.out.println("Solução: Envolver objetos em decoradores que adicionam novos comportamentos\n");
        
        String salaryRecords = "Nome,Salário\nJoão Silva,5000\nMaria Santos,6000\nPedro Oliveira,4500";
        
        System.out.println("Dados originais:");
        System.out.println(salaryRecords);
        CmdVisualUtils.separetorCmd(50);

        // Teste 1: Fonte de dados simples
        System.out.println("Teste 1: Arquivo simples");
        DataSource source = new FileDataSource("output.txt");
        source.writeData(salaryRecords);
        String data = source.readData();
        System.out.println("Dados lidos: " + data.substring(0, Math.min(50, data.length())) + "...");

        CmdVisualUtils.separetorCmd(50);

        // Teste 2: Com criptografia
        System.out.println("Teste 2: Arquivo com criptografia");
        source = new EncryptionDecorator(new FileDataSource("encrypted.txt"));
        source.writeData(salaryRecords);
        data = source.readData();
        System.out.println("Dados descriptografados: " + data.substring(0, Math.min(50, data.length())) + "...");

        CmdVisualUtils.separetorCmd(50);

        // Teste 3: Com compressão
        System.out.println("Teste 3: Arquivo com compressão");
        source = new CompressionDecorator(new FileDataSource("compressed.txt"));
        source.writeData(salaryRecords);
        data = source.readData();
        System.out.println("Dados descomprimidos: " + data.substring(0, Math.min(50, data.length())) + "...");

        CmdVisualUtils.separetorCmd(50);

        // Teste 4: Com criptografia E compressão
        System.out.println("Teste 4: Arquivo com criptografia E compressão");
        source = new CompressionDecorator(
                    new EncryptionDecorator(
                        new FileDataSource("encrypted_compressed.txt")));
        source.writeData(salaryRecords);
        data = source.readData();
        System.out.println("Dados processados: " + data.substring(0, Math.min(50, data.length())) + "...");

        CmdVisualUtils.separetorCmd(50);

        // Teste 5: Ordem diferente dos decoradores
        System.out.println("Teste 5: Ordem diferente - Criptografia depois Compressão");
        source = new EncryptionDecorator(
                    new CompressionDecorator(
                        new FileDataSource("compressed_encrypted.txt")));
        source.writeData(salaryRecords);
        data = source.readData();
        System.out.println("Dados processados: " + data.substring(0, Math.min(50, data.length())) + "...");
        
        System.out.println("\nVantagens:");
        System.out.println("- Estende comportamento de objetos sem alterar seu código");
        System.out.println("- Permite combinar vários comportamentos envolvendo um objeto em múltiplos decoradores");
        System.out.println("- Segue o princípio Single Responsibility");
        System.out.println("- Permite adicionar ou remover responsabilidades em tempo de execução");
        System.out.println("- Alternativa flexível à herança para estender funcionalidade");
    }
}


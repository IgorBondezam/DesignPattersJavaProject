package org.example.designpatterns.structural.decorator;

import java.io.*;

public class FileDataSource implements DataSource {
    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        try (FileWriter writer = new FileWriter(name)) {
            writer.write(data);
            System.out.println("Dados escritos no arquivo: " + name);
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }

    @Override
    public String readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            System.out.println("Dados lidos do arquivo: " + name);
            return result.toString();
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            return "";
        }
    }
}


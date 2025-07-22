package com.igorbondezam.designpatterns.behavioral.templatemethod;

import java.io.File;

public abstract class DataMiner {
    
    // Template method define o esqueleto do algoritmo
    public final void mineData(String path) {
        File file = openFile(path);
        String rawData = extractData(file);
        String data = parseData(rawData);
        String analysis = analyzeData(data);
        sendReport(analysis);
        closeFile(file);
    }

    protected File openFile(String path) {
        System.out.println("Abrindo arquivo: " + path);
        return new File(path);
    }

    // Métodos abstratos que devem ser implementados pelas subclasses
    protected abstract String extractData(File file);
    protected abstract String parseData(String rawData);

    protected String analyzeData(String data) {
        System.out.println("Analisando dados...");
        return "Análise dos dados: " + data;
    }

    protected void sendReport(String analysis) {
        System.out.println("Enviando relatório: " + analysis);
    }

    protected void closeFile(File file) {
        System.out.println("Fechando arquivo: " + file.getName());
    }
}


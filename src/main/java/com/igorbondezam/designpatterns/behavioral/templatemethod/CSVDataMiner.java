package com.igorbondezam.designpatterns.behavioral.templatemethod;

import java.io.File;

public class CSVDataMiner extends DataMiner {

    @Override
    protected String extractData(File file) {
        System.out.println("Extraindo dados do CSV...");
        return "Dados brutos do CSV: linhas separadas por vírgula";
    }

    @Override
    protected String parseData(String rawData) {
        System.out.println("Parseando dados do CSV...");
        return "Dados parseados do CSV: colunas e linhas estruturadas";
    }
}


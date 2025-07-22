package org.example.designpatterns.behavioral.templatemethod;

import java.io.File;

public class PDFDataMiner extends DataMiner {

    @Override
    protected String extractData(File file) {
        System.out.println("Extraindo dados do PDF...");
        return "Dados brutos do PDF: conteúdo textual, imagens, metadados";
    }

    @Override
    protected String parseData(String rawData) {
        System.out.println("Parseando dados do PDF...");
        return "Dados parseados do PDF: texto estruturado, tabelas extraídas";
    }
}


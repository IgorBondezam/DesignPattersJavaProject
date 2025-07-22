package org.example.designpatterns.behavioral.templatemethod;

import java.io.File;

public class DocDataMiner extends DataMiner {

    @Override
    protected String extractData(File file) {
        System.out.println("Extraindo dados do DOC...");
        return "Dados brutos do DOC: texto formatado, estilos, imagens";
    }

    @Override
    protected String parseData(String rawData) {
        System.out.println("Parseando dados do DOC...");
        return "Dados parseados do DOC: texto limpo, formatação preservada";
    }

    // Sobrescreve método hook para personalizar comportamento
    @Override
    protected void sendReport(String analysis) {
        System.out.println("Enviando relatório DOC por email corporativo: " + analysis);
    }
}


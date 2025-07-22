package com.igorbondezam.designpatterns.behavioral.visitor;

import com.igorbondezam.utils.CmdVisualUtils;

public class VisitorDemo {
    
    public static void demonstrate() {
        System.out.println("=== VISITOR PATTERN ===");
        System.out.println("Problema: Executar operações em elementos de estrutura de objetos sem modificar suas classes");
        System.out.println("Solução: Separar algoritmos dos objetos nos quais operam\n");
        
        // Criando estrutura de dados
        City city = new City("São Paulo");
        city.addNode(new Industry("Fábrica de Automóveis", 1500));
        city.addNode(new Industry("Usina Siderúrgica", 2000));
        city.addNode(new SightSeeing("Museu de Arte", 50));
        city.addNode(new SightSeeing("Parque Ibirapuera", 0));
        city.addNode(new SightSeeing("Teatro Municipal", 75));
        
        System.out.println("Estrutura criada: Cidade com indústrias e pontos turísticos\n");
        
        // Teste 1: Calculando custos
        System.out.println("Teste 1: Calculando custos totais");
        CostCalculatorVisitor costCalculator = new CostCalculatorVisitor();
        city.accept(costCalculator);
        System.out.println("Custo total: $" + costCalculator.getTotalCost());

        CmdVisualUtils.separetorCmd(60);

        // Teste 2: Exportando para XML
        System.out.println("Teste 2: Exportando para XML");
        XMLExportVisitor xmlExporter = new XMLExportVisitor();
        city.accept(xmlExporter);
        System.out.println("XML gerado:");
        System.out.println(xmlExporter.getXML());

        CmdVisualUtils.separetorCmd(60);

        // Teste 3: Exportando para JSON
        System.out.println("Teste 3: Exportando para JSON");
        JSONExportVisitor jsonExporter = new JSONExportVisitor();
        city.accept(jsonExporter);
        System.out.println("JSON gerado:");
        System.out.println(jsonExporter.getJSON());

        CmdVisualUtils.separetorCmd(60);

        // Teste 4: Visitor personalizado
        System.out.println("Teste 4: Visitor personalizado - Contador de elementos");
        Visitor counterVisitor = new Visitor() {
            private int cityCount = 0;
            private int industryCount = 0;
            private int sightseeingCount = 0;
            
            @Override
            public void visit(City city) {
                cityCount++;
                System.out.println("Visitando cidade: " + city.getName());
            }
            
            @Override
            public void visit(Industry industry) {
                industryCount++;
                System.out.println("Visitando indústria: " + industry.getName());
            }
            
            @Override
            public void visit(SightSeeing sightSeeing) {
                sightseeingCount++;
                System.out.println("Visitando ponto turístico: " + sightSeeing.getName());
            }
            
            public void printCounts() {
                System.out.println("Contagem: " + cityCount + " cidades, " + 
                                 industryCount + " indústrias, " + 
                                 sightseeingCount + " pontos turísticos");
            }
        };
        
        city.accept(counterVisitor);
        System.out.println("Contagem: 1 cidade, 2 indústrias, 3 pontos turísticos");
        
        System.out.println("\nVantagens:");
        System.out.println("- Adiciona operações sem modificar classes existentes");
        System.out.println("- Agrupa operações relacionadas em uma classe");
        System.out.println("- Facilita adição de novos tipos de operações");
        System.out.println("- Segue o princípio Single Responsibility");
        System.out.println("- Permite acumular estado durante travessia");
    }
}


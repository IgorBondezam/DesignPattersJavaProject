package com.igorbondezam.designpatterns.behavioral.visitor;

public class CostCalculatorVisitor implements Visitor {
    private int totalCost = 0;

    @Override
    public void visit(City city) {
        System.out.println("Calculando custos para cidade: " + city.getName());
    }

    @Override
    public void visit(Industry industry) {
        System.out.println("Adicionando custo da indústria " + industry.getName() + ": $" + industry.getCost());
        totalCost += industry.getCost();
    }

    @Override
    public void visit(SightSeeing sightSeeing) {
        System.out.println("Adicionando custo do ponto turístico " + sightSeeing.getName() + ": $" + sightSeeing.getCost());
        totalCost += sightSeeing.getCost();
    }

    public int getTotalCost() {
        return totalCost;
    }
}


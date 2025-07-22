package org.example.designpatterns.behavioral.visitor;

public class Industry implements Node {
    private String name;
    private int cost;

    public Industry(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}


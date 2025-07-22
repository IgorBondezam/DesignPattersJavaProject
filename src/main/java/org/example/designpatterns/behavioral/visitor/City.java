package org.example.designpatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class City implements Node {
    private String name;
    private List<Node> nodes = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public String getName() {
        return name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Node node : nodes) {
            node.accept(visitor);
        }
    }
}


package com.igorbondezam.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompoundGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic child) {
        children.add(child);
    }

    public void remove(Graphic child) {
        children.remove(child);
    }

    @Override
    public void move(int x, int y) {
        for (Graphic child : children) {
            child.move(x, y);
        }
    }

    @Override
    public void draw() {
        System.out.println("Desenhando grupo composto:");
        for (int i = 0; i < children.size(); i++) {
            System.out.print("  " + (i + 1) + ". ");
            children.get(i).draw();
        }
        System.out.println("Fim do grupo composto");
    }
}


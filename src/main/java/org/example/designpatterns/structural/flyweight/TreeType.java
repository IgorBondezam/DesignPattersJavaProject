package org.example.designpatterns.structural.flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class TreeType {
    private String name;
    private Color color;
    private String sprite;

    public TreeType(String name, Color color, String sprite) {
        this.name = name;
        this.color = color;
        this.sprite = sprite;
    }

    public void render(Graphics g, int x, int y) {
        // Simula renderização da árvore
        System.out.println("Renderizando " + name + " " + color + " na posição (" + x + ", " + y + ") com sprite: " + sprite);
    }
}


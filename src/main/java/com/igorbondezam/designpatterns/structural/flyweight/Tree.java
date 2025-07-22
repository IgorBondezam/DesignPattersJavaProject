package com.igorbondezam.designpatterns.structural.flyweight;

import java.awt.Graphics;

public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void render(Graphics g) {
        type.render(g, x, y);
    }
}


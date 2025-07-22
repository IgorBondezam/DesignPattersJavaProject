package org.example.designpatterns.structural.flyweight;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String sprite) {
        TreeType type = TreeTypeFactory.getTreeType(name, color, sprite);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void render(Graphics g) {
        for (Tree tree : trees) {
            tree.render(g);
        }
    }

    public int getTreeCount() {
        return trees.size();
    }
}


package com.igorbondezam.designpatterns.structural.flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String sprite) {
        String key = name + color.toString() + sprite;
        TreeType result = treeTypes.get(key);
        if (result == null) {
            result = new TreeType(name, color, sprite);
            treeTypes.put(key, result);
            System.out.println("Criando novo TreeType: " + name + " (Total de tipos: " + treeTypes.size() + ")");
        } else {
            System.out.println("Reutilizando TreeType existente: " + name);
        }
        return result;
    }

    public static int getCreatedTreeTypesCount() {
        return treeTypes.size();
    }
}


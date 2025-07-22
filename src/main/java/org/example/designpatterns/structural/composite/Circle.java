package org.example.designpatterns.structural.composite;

public class Circle extends Dot {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Desenhando círculo na posição (" + super.x + ", " + super.y + ") com raio " + radius + " ⭕");
    }
}

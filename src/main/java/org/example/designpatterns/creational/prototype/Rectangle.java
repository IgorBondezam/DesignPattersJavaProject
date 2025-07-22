package org.example.designpatterns.creational.prototype;

public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle() {}

    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void draw() {
        System.out.println("Desenhando retângulo:");
        System.out.println("  Posição: (" + x + ", " + y + ")");
        System.out.println("  Cor: " + color);
        System.out.println("  Largura: " + width + ", Altura: " + height);
        System.out.println("  Representação: ▭");
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }
}


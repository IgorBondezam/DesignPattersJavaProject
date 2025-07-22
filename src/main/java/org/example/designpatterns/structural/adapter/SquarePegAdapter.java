package org.example.designpatterns.structural.adapter;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        // Calcula o raio mínimo do círculo que pode conter o quadrado
        return (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
    }
}


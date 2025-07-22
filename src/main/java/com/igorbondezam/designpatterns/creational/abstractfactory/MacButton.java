package com.igorbondezam.designpatterns.creational.abstractfactory;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Renderizando button Mac: ✓ Opção selecionada");
    }
}


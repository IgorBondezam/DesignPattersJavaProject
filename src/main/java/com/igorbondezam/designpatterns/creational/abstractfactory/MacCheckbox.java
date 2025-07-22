package com.igorbondezam.designpatterns.creational.abstractfactory;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Renderizando checkbox Mac: ✓ Opção selecionada");
    }
}


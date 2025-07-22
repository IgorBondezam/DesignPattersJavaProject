package com.igorbondezam.designpatterns.creational.abstractfactory;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Renderizando checkbox Windows: [X] Opção selecionada");
    }
}


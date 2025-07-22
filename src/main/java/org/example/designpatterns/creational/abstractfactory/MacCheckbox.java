package org.example.designpatterns.creational.abstractfactory;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Renderizando checkbox Mac: ✓ Opção selecionada");
    }
}


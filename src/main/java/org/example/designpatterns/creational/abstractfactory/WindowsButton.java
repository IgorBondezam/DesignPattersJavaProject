package org.example.designpatterns.creational.abstractfactory;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Renderizando botão Windows: [ OK ]");
    }
}
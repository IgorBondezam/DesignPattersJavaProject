package com.igorbondezam.designpatterns.creational.factorymethod;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando botão no estilo Windows");
        System.out.println("[ Botão Windows ]");
    }

    @Override
    public void onClick() {
        System.out.println("Clique no botão Windows detectado!");
    }
}


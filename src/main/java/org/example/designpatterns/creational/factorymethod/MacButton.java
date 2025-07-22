package org.example.designpatterns.creational.factorymethod;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando botão no estilo Mac");
        System.out.println("( Botão Mac )");
    }

    @Override
    public void onClick() {
        System.out.println("Clique no botão Mac detectado!");
    }
}


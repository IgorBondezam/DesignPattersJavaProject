package com.igorbondezam.designpatterns.creational.factorymethod;

public abstract class Dialog {
    
    // Factory Method - deve ser implementado pelas subclasses
    public abstract Button createButton();
    
    // Método que usa o Factory Method
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
        okButton.onClick();
    }
}


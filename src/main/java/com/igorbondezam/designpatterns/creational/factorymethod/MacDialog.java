package com.igorbondezam.designpatterns.creational.factorymethod;

public class MacDialog extends Dialog {
    @Override
    public Button createButton() {
        return new MacButton();
    }
}


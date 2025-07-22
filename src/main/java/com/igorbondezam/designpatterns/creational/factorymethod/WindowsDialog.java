package com.igorbondezam.designpatterns.creational.factorymethod;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}


package org.example.designpatterns.structural.decorator;

public interface DataSource {
    void writeData(String data);
    String readData();
}


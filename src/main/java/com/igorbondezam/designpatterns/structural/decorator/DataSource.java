package com.igorbondezam.designpatterns.structural.decorator;

public interface DataSource {
    void writeData(String data);
    String readData();
}


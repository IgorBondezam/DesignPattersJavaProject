package org.example.designpatterns.behavioral.chainofresponsibility;

public interface Handler {
    void setNext(Handler handler);
    boolean handle(String request);
}


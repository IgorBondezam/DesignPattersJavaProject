package org.example.designpatterns.behavioral.chainofresponsibility;

public abstract class AbstractHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public boolean handle(String request) {
        if (nextHandler != null) {
            return nextHandler.handle(request);
        }
        return false;
    }
}


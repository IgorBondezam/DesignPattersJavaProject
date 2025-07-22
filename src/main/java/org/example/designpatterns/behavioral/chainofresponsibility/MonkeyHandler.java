package org.example.designpatterns.behavioral.chainofresponsibility;

public class MonkeyHandler extends AbstractHandler {
    @Override
    public boolean handle(String request) {
        if (request.equals("Banana")) {
            System.out.println("Macaco: Eu vou comer a " + request + "!");
            return true;
        } else {
            System.out.println("Macaco: Eu não como " + request + ".");
            return super.handle(request);
        }
    }
}


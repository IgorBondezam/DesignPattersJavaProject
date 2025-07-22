package com.igorbondezam.designpatterns.behavioral.chainofresponsibility;

public class DogHandler extends AbstractHandler {
    @Override
    public boolean handle(String request) {
        if (request.equals("Carne")) {
            System.out.println("Cachorro: Eu vou comer a " + request + "!");
            return true;
        } else {
            System.out.println("Cachorro: Eu não como " + request + ".");
            return super.handle(request);
        }
    }
}


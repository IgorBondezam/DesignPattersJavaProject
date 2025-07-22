package com.igorbondezam.designpatterns.behavioral.chainofresponsibility;

public class SquirrelHandler extends AbstractHandler {
    @Override
    public boolean handle(String request) {
        if (request.equals("Noz")) {
            System.out.println("Esquilo: Eu vou comer a " + request + "!");
            return true;
        } else {
            System.out.println("Esquilo: Eu não como " + request + ".");
            return super.handle(request);
        }
    }
}


package com.igorbondezam.designpatterns.behavioral.observer;

public class LogOpenListener implements EventListener {
    private String log;

    public LogOpenListener(String fileName) {
        this.log = fileName;
    }

    @Override
    public void update(String eventType, String data) {
        System.out.println("Salvando no log " + log + ": Alguém executou " + eventType + " no arquivo " + data);
    }
}


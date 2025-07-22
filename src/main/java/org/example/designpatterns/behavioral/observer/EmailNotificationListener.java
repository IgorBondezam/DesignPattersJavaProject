package org.example.designpatterns.behavioral.observer;

public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, String data) {
        System.out.println("Email para " + email + ": Alguém executou " + eventType + " no arquivo " + data);
    }
}


package com.igorbondezam.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private String email;
    private List<String> contacts = new ArrayList<>();

    public Profile(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void addContact(String contactEmail) {
        contacts.add(contactEmail);
    }
}


package org.example.designpatterns.behavioral.iterator;

public interface ProfileIterator {
    boolean hasNext();
    Profile getNext();
    void reset();
}


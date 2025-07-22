package org.example.designpatterns.behavioral.visitor;

public interface Visitor {
    void visit(City city);
    void visit(Industry industry);
    void visit(SightSeeing sightSeeing);
}


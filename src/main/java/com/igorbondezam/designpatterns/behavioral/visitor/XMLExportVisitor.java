package com.igorbondezam.designpatterns.behavioral.visitor;

public class XMLExportVisitor implements Visitor {
    private StringBuilder xml = new StringBuilder();

    @Override
    public void visit(City city) {
        xml.append("<city name=\"").append(city.getName()).append("\">\n");
    }

    @Override
    public void visit(Industry industry) {
        xml.append("  <industry name=\"").append(industry.getName())
           .append("\" cost=\"").append(industry.getCost()).append("\"/>\n");
    }

    @Override
    public void visit(SightSeeing sightSeeing) {
        xml.append("  <sightseeing name=\"").append(sightSeeing.getName())
           .append("\" cost=\"").append(sightSeeing.getCost()).append("\"/>\n");
    }

    public String getXML() {
        return xml.toString() + "</city>\n";
    }
}


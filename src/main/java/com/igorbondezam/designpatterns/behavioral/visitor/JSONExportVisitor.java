package com.igorbondezam.designpatterns.behavioral.visitor;

public class JSONExportVisitor implements Visitor {
    private StringBuilder json = new StringBuilder();
    private boolean firstElement = true;

    @Override
    public void visit(City city) {
        json.append("{\n  \"city\": \"").append(city.getName()).append("\",\n");
        json.append("  \"attractions\": [\n");
        firstElement = true;
    }

    @Override
    public void visit(Industry industry) {
        if (!firstElement) {
            json.append(",\n");
        }
        json.append("    {\"type\": \"industry\", \"name\": \"")
           .append(industry.getName()).append("\", \"cost\": ")
           .append(industry.getCost()).append("}");
        firstElement = false;
    }

    @Override
    public void visit(SightSeeing sightSeeing) {
        if (!firstElement) {
            json.append(",\n");
        }
        json.append("    {\"type\": \"sightseeing\", \"name\": \"")
           .append(sightSeeing.getName()).append("\", \"cost\": ")
           .append(sightSeeing.getCost()).append("}");
        firstElement = false;
    }

    public String getJSON() {
        return json.toString() + "\n  ]\n}\n";
    }
}


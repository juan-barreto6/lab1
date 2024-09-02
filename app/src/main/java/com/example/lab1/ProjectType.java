package com.example.lab1;

public class ProjectType {
    private final String name;
    private final String[] interventions;

    public ProjectType(String name, String[] interventions) {
        this.name = name;
        this.interventions = interventions;
    }

    public String getName() {
        return name;
    }

    public String[] getInterventions() {
        return interventions;
    }
}

package com.google.sps.servlets;

public class Resource {
    private final Organizer organizer;
    private final int id;
    private final String eventName;
    private final String location;
    private final String link;
    private final String description;
    private final String[] ethnicity;

    public Resource(Organizer organizer, int id, String eventName, String location, String link, String description, String[] ethnicity) {
        this.organizer = organizer;
        this.id = id;
        this.eventName = eventName;
        this.location = location;
        this.link = link;
        this.description = description;
        this.ethnicity = ethnicity;
    }
}

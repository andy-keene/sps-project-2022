package com.google.sps.servlets;

public final class Resource {
    private final String organizerName;
    private final String organizerEmail;
    private final long id;
    private final String eventName;
    private final String eventDate;
    private final String[] ageGroup;
    private final String location;
    private final String link;
    private final String description;
    private final String[] ethnicity;

    public Resource(String organizerName, String organizerEmail, long id, String eventName, String eventDate, String[] ageGroup, String location, String link, String description, String[] ethnicity) {
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.ageGroup = ageGroup;
        this.location = location;
        this.link = link;
        this.description = description;
        this.ethnicity = ethnicity;
    }
}

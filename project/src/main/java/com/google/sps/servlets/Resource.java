package com.google.sps.servlets;

import java.util.ArrayList;
import java.util.List;

public final class Resource {
    private final String organizerName;
    private final String organizerEmail;
    private final long id;
    private final String eventName;
    private final String eventDate;
    private final List<String> ageGroup;
    private final String location;
    private final String link;
    private final String description;
    private final List<String> ethnicity;

    public Resource(String organizerName, String organizerEmail, long id, String eventName, String eventDate, List<String> ageGroup, String location, String link, String description, List<String> ethnicity) {
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

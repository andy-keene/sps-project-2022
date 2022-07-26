package com.google.sps.servlets;

import javax.imageio.plugins.tiff.ExifInteroperabilityTagSet;


public final class Resource {
    private final long id;
    private final long timestamp;
    private final String organizerName;
    private final String organizerEmail;
    private final String eventName;
    private final String eventDate;
    private final String location;
    private final String link;
    private final String description;
    private final String ageGroup;
    private final String ethnicity;

    // Example of turning comma-delimited string into a list.
    // This is stored in a separate field so changing the type from String to [] does not
    // crash the front end.
    private final String[] ageGroupList;

    // Example of storing array from native array field in Datastore
    private String[] colors;

    public Resource(long id, long timestamp, String organizerName, String organizerEmail, String eventName, String eventDate, String location, String link, String description, String ageGroup, String ethnicity) {
        this.id = id;
        this.timestamp = timestamp;
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.ageGroup = ageGroup;
        this.location = location;
        this.link = link;
        this.description = description;
        this.ethnicity = ethnicity;

        this.ageGroupList =  ageGroup.split(",");
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }
}

package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Value;

import com.google.cloud.datastore.ListValue;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resource-handler")
public class ResourceHandlerServlet extends HttpServlet {

    private static final List<String> ageGroupOptions = new ArrayList<>(Arrays.asList(
        "gradeNine",
        "gradeTen",
        "gradeEleven",
        "gradeTwelve",
        "freshman",
        "sophomore",
        "junior",
        "senior",
        "graduate"));

    private static final List<String> ethnicityOptions = new ArrayList<>(Arrays.asList(
        "White",
        "Black",
        "Hispanic",
        "Asian",
        "American Indian or Alaska Native",
        "Middle Eastern",
        "Two or More Races",
        "Prefer Not to Answer"));

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the values entered by the user
        long timestamp = System.currentTimeMillis();
        String organizerName = request.getParameter("inputName");
        String organizerEmail = request.getParameter("inputEmail");
        String eventName = request.getParameter("inputEventName");
        String eventDate = request.getParameter("inputDate");
        String location = request.getParameter("inputEventLocation");
        String link = request.getParameter("inputLink");
        String description = request.getParameter("inputDesciption");

        String ageGroup = ageGroupOptions.stream()
                .map(request::getParameter)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
        String ethnicity = ethnicityOptions.stream()
                .map(request::getParameter)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));

        // Print the value so you can see it in the server logs.
        System.out.println("You submitted: " + organizerName);
        System.out.println("You submitted: " + organizerEmail);
        System.out.println("You submitted: " + eventName);
        System.out.println("You submitted: " + eventDate);
        System.out.println("You submitted: " + location);
        System.out.println("You submitted: " + link);
        System.out.println("You submitted: " + description);

        // Datastore code
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Resource");
        FullEntity taskEntity =
                Entity.newBuilder(keyFactory.newKey())
                .set("timestamp", timestamp)
                .set("organizerName", organizerName)
                .set("organizerEmail", organizerEmail)
                .set("eventName", eventName)
                .set("eventDate", eventDate)
                .set("location", location)
                .set("link", link)
                .set("description", description)
                .set("ageGroup", ageGroup)
                .set("ethnicity", ethnicity)
                .build();
        datastore.put(taskEntity);
        response.sendRedirect("/view-events.html");
    }
}
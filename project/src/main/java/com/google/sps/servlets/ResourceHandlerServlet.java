package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resource-handler")
public class ResourceHandlerServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the values entered by the user
        String organizerName = request.getParameter("inputName");
        String organizerEmail = request.getParameter("inputEmail");
        String eventName = request.getParameter("inputEventName");
        String eventDate = request.getParameter("inputDate");
        String location = request.getParameter("inputEventLocation");
        String link = request.getParameter("inputLink");
        String description = request.getParameter("inputDesciption");

        // Create array for age groups
        List<String> ageGroup = new ArrayList<>();

        if (request.getParameter("gradeNine") != null) {
            ageGroup.add("Grade 9");
        }
        if (request.getParameter("gradeTen") != null) {
            ageGroup.add("Grade 10");
        }
        if (request.getParameter("gradeEleven") != null) {
            ageGroup.add("Grade 11");
        }
        if (request.getParameter("gradeTwelve") != null) {
            ageGroup.add("Grade 12");
        }
        if (request.getParameter("freshman") != null) {
            ageGroup.add("Freshman");
        }
        if (request.getParameter("sophomore") != null) {
            ageGroup.add("Sophomore");
        }
        if (request.getParameter("junior") != null) {
            ageGroup.add("Junior");
        }
        if (request.getParameter("senior") != null) {
            ageGroup.add("Senior");
        }
        
        // Create array for ethnicities
        List<String> ethnicities = new ArrayList<>();

        if (request.getParameter("white") != null) {
            ethnicities.add("White");
        }
        if (request.getParameter("black") != null) {
            ethnicities.add("Black");
        }
        if (request.getParameter("hispanic") != null) {
            ethnicities.add("Hispanic");
        }
        if (request.getParameter("asian") != null) {
            ethnicities.add("Asian");
        }
        if (request.getParameter("americanIndian") != null) {
            ethnicities.add("American Indian or Alaska Native");
        }
        if (request.getParameter("middleEastern") != null) {
            ethnicities.add("Middle Eastern");
        }
        if (request.getParameter("twoOrMore") != null) {
            ethnicities.add("2 or more");
        }
        if (request.getParameter("notToAnswer") != null) {
            ethnicities.add("Prefer not to answer");
        }

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
                .set("organizerName", organizerName)
                .set("organizerEmail", organizerEmail)
                .set("eventName", eventName)
                .set("eventDate", eventDate)
                .set("location", location)
                .set("link", link)
                .set("description", description)
                // .set("ageGroup", ageGroup)
                // .set("ethnicities", ethnicities)
                .build();
        datastore.put(taskEntity);
        response.sendRedirect("/start-page.html");

        // Write the value to the response so the user can see it
        response.setContentType("text/html;");
        response.getWriter().println("Organizer name: " + organizerName);
        response.getWriter().println("Organizer email: " + organizerEmail);
        response.getWriter().println("Event name: " + eventName);
        response.getWriter().println("Event date: " + eventDate);
        response.getWriter().println("Location: " + location);
        response.getWriter().println("Location: " + link);
        response.getWriter().println("Location: " + description);

        response.getWriter().println("ageGroup count: " + ageGroup.size());
        response.getWriter().println("ethnicities count: " + ethnicities.size());

        for (int i = 0; i < ageGroup.size(); i++) {
            response.getWriter().println("AgeGroup: " + ageGroup.get(i));
        }
        for (int i = 0; i < ethnicities.size(); i++) {
            response.getWriter().println("Ethnicity: " + ethnicities.get(i));
        }
    }
}
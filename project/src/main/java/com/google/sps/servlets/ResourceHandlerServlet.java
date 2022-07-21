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
        String ethnicity = request.getParameter("white");

        String nine = request.getParameter("gradeNine");

        // Create array for age groups
        List<String> ageGroup = new ArrayList<>();

        ageGroup.add(request.getParameter("gradeNine"));

        if (request.getParameter("gradeNine") == "Grade 9") {
            ageGroup.add("Grade 9");
        }
        if (request.getParameter("gradeTen") == "Grade 10") {
            ageGroup.add("Grade 10");
        }
        if (request.getParameter("gradeEleven") == "Grade 11") {
            ageGroup.add("Grade 11");
        }
        if (request.getParameter("gradeTwelve") == "Grade 12") {
            ageGroup.add("Grade 12");
        }
        if (request.getParameter("freshman") == "Freshman") {
            ageGroup.add("Freshman");
        }
        if (request.getParameter("sophomore") == "Sophomore") {
            ageGroup.add("Sophomore");
        }
        if (request.getParameter("junior") == "Junior") {
            ageGroup.add("Junior");
        }
        if (request.getParameter("senior") == "Senior") {
            ageGroup.add("Senior");
        }
        

        // Print the value so you can see it in the server logs.
        System.out.println("You submitted: " + organizerName);
        System.out.println("You submitted: " + organizerEmail);
        System.out.println("You submitted: " + eventName);
        System.out.println("You submitted: " + eventDate);
        System.out.println("You submitted: " + location);
        System.out.println("You submitted: " + link);
        System.out.println("You submitted: " + description);
        System.out.println("You submitted: " + nine);

        // System.out.println("You submitted: " + ageGroup);

        // Datastore code
        // Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        // KeyFactory keyFactory = datastore.newKeyFactory().setKind("Resource");
        // FullEntity taskEntity =
        //     Entity.newBuilder(keyFactory.newKey())
        //         .set("organizerName", organizerName)
        //         .set("organizerEmail", organizerEmail)
        //         .set("eventName", eventName)
        //         .set("eventDate", eventDate)
        //         .set("location", location)
        //         .set("link", link)
        //         .set("description", description)
        //         .set("ethnicity", ethnicity)
        //         .build();
        // datastore.put(taskEntity);
        // response.sendRedirect("/index.html");

        // Write the value to the response so the user can see it
        response.setContentType("text/html;");
        response.getWriter().println("You submitted: " + organizerName);
        response.getWriter().println("You submitted: " + organizerEmail);
        response.getWriter().println("You submitted: " + eventName);
        response.getWriter().println("You submitted: " + eventDate);
        response.getWriter().println("You submitted: " + location);

        response.getWriter().println("You submitted: " + nine);
        response.getWriter().println("You submitted: " + ageGroup.get(0));

        // for (int i = 0; i < ageGroup.size(); i++) {
        //     response.getWriter().println("You submitted: " + ageGroup.get(1));
        // }
        // response.getWriter().println("You submitted: " + ageGroup.get(1));
        // response.getWriter().println("You submitted: " + ageGroup.get(2));
        // response.getWriter().println("You submitted: " + ageGroup.get(0));

        response.getWriter().println("You submitted: " + ethnicity);
    }
}
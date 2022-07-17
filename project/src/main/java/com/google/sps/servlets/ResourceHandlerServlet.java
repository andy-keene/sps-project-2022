package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

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
        // String id = request.getParameter("greeting-container");
        String eventName = request.getParameter("inputEventName");
        String eventDate = request.getParameter("inputDate");
        // String[] ageGroup;
        String location = request.getParameter("inputEventLocation");
        String link = request.getParameter("inputLink");
        String description = request.getParameter("inputDesciption");
        String ethnicity = request.getParameter("inlineCheckboxOptions");

        // for(int i=0; i<)

        // Print the value so you can see it in the server logs.
        System.out.println("You submitted: " + organizerName);
        System.out.println("You submitted: " + organizerEmail);
        System.out.println("You submitted: " + eventName);
        System.out.println("You submitted: " + eventDate);
        System.out.println("You submitted: " + location);
        System.out.println("You submitted: " + ethnicity);

        // Datastore code
        String title = request.getParameter("title");
        long timestamp = System.currentTimeMillis();

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
        FullEntity taskEntity =
            Entity.newBuilder(keyFactory.newKey())
                .set("title", title)
                .set("timestamp", timestamp)
                .build();
        datastore.put(taskEntity);
        response.sendRedirect("/index.html");

        // Write the value to the response so the user can see it
        response.setContentType("text/html;");
        response.getWriter().println("You submitted: " + organizerName);
        response.getWriter().println("You submitted: " + organizerEmail);
        response.getWriter().println("You submitted: " + eventName);
        response.getWriter().println("You submitted: " + eventDate);
        response.getWriter().println("You submitted: " + location);
        response.getWriter().println("You submitted: " + ethnicity);
    }
}

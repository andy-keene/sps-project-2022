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
// Do later: import jSoup to sanitize user input

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
        // String[] ethnicity;

        // Print the value so you can see it in the server logs.
        System.out.println("You submitted: " + organizerName);

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Resource");
        FullEntity taskEntity = Entity.newBuilder(keyFactory.newKey())
                .set("organizerName", organizerName)
                // need to add other ones too, will be able to verify once frontend has JS ready
                .build();
        datastore.put(taskEntity);

        // Write the value to the response so the user can see it
        response.setContentType("text/html;");
        response.getWriter().println("You submitted: " + organizerName);
    }
}
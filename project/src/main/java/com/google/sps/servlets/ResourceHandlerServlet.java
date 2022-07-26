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
            "ageGroup-1",
            "ageGroup-2",
            "ageGroup-3",
            "ageGroup-4",
            "ageGroup-5",
            "ageGroup-6",
            "ageGroup-7",
            "ageGroup-8",
            "ageGroup-9"));

    private static final List<String> enthnicityOptions = new ArrayList<>(Arrays.asList(
            // do the same for enthnicity
            "enthnicity-1"));

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

        // Hack to store a list as a comma-delimited string
        String ageGroups = ageGroupOptions.stream()
                .map(request::getParameter)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(","));

        String ethnicities = enthnicityOptions.stream()
                .map(request::getParameter)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(","));

        // Datastore code
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Resource");
        FullEntity taskEntity = Entity.newBuilder(keyFactory.newKey())
                .set("timestamp", System.currentTimeMillis())
                .set("organizerName", organizerName)
                .set("organizerEmail", organizerEmail)
                .set("eventName", eventName)
                .set("eventDate", eventDate)
                .set("location", location)
                .set("link", link)
                .set("description", description)
                // Example of how to store a list as type String
                .set("ageGroup", ageGroups)
                .set("ethnicity", ethnicities)
                // Documentation
                // https://cloud.google.com/datastore/docs/samples/datastore-array-value#datastore_array_value-java
                // https://cloud.google.com/java/docs/reference/google-cloud-datastore/latest/com.google.cloud.datastore.ListValue#com_google_cloud_datastore_ListValue_newBuilder__
                // To pass in a single list, per the documentation we must create one of type List<Value> 
                // Example of how to create a true array in Datastore
                .set("colors", ListValue.of("red", "blue"))
                .build();
        datastore.put(taskEntity);
        response.sendRedirect("/view-events.html");
    }

    /**
     * Retrieves the value of the provided parameter name if it exists; otherwise
     * returns an empty String
     */
    private static String getOrDefault(HttpServletRequest request, String parameterName) {
        return "";
    }
}
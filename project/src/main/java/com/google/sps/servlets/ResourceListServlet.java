package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.sps.servlets.Resource;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet responsible for listing form responses
@WebServlet("/form-responses")
public class ResourceListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("Resource")
                .build();
        QueryResults<Entity> results = datastore.run(query);

        List<String> temp = new ArrayList<>(Arrays.asList("String", "String2"));

        List<Resource> formResponses = new ArrayList<>();
        while (results.hasNext()) {
            Entity entity = results.next();

            long id = entity.getKey().getId();
            String organizerName = entity.getString("organizerName");
            String organizerEmail = entity.getString("organizerEmail");
            String eventName = entity.getString("eventName");
            String eventDate = entity.getString("eventDate");
            String location = entity.getString("location");
            String link = entity.getString("link");
            String description = entity.getString("description");
            List<String> ageGroup = entity.getValue("ageGroup");
            List<String> ethnicities = entity.getValue("description");

            // Task task = new Task(id, title, timestamp);
            // tasks.add(task);
        }
        Gson gson = new Gson();
        response.setContentType("application/json;");
        response.getWriter().println(gson.toJson(formResponses));
    }
}

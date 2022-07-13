package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import com.google.gson.Gson;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;

/**
 * Handles listing and creating event resources.
 */
@WebServlet("/resources")
public class ResourceServlet extends HttpServlet {

    class Resource {
        String name;
        String date;
        String availability;
    }

    // Simple data persistence. Data is only cleared on a server restart. 
    private ArrayList<Resource> resources = new ArrayList<>();
    private static final Gson gson = new Gson();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;");
        response.getWriter().println(gson.toJson(resources));
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // How to extract the JSON string in the request body:
        // Option 1 (reqs dependency) IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        // Option 2 (native Java) request.getReader().lines().collect(Collectors.joining());
        //
        // How to convert json string to the Resource class defined above:
        // https://github.com/google/gson/blob/master/UserGuide.md#object-examples

        String requestBody = request.getReader().lines().collect(Collectors.joining());
        Resource resource = new Gson().fromJson(requestBody, Resource.class);

        resources.add(resource);
        System.out.println("[akeene] Added resource:" + requestBody);
    }

}

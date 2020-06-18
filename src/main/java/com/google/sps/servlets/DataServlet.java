// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Date;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.lang.String;
//import com.google.sps.data.Task;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    ArrayList<String> messages = new ArrayList<String>();
    //DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Query query = new Query("Message").addSort("message-container", SortDirection.DESCENDING);
        
        Gson gson = new Gson();
        String json = gson.toJson(messages);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery results = datastore.prepare(query);

        List<String> messages = new ArrayList<>();
        for (Entity entity : results.asIterable()) {
            //long id = messageEnt.getKey().getId();
            String message = (String) entity.getProperty("message-container");
            //long timestamp = (long) messageEnt.getProperty("timestamp");
            response.getOutputStream().println(message);
            //String messages = new Message(message-container);
            //messages.add(message);
        }
    //          response.setContentType("application/json;");


        // Query query = new Query("Task").addSort("timestamp", SortDirection.DESCENDING);

        // DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        // PreparedQuery results = datastore.prepare(query);

        // List<Task> tasks = new ArrayList<>();
        // for (Entity entity : results.asIterable()) {
        //   long id = entity.getKey().getId();
        //   String title = (String) entity.getProperty("title");
        //   long timestamp = (long) entity.getProperty("timestamp");

        //   Task task = new Task(id, title, timestamp);
        //   tasks.add(task);
    // }
        // Gson gson = new Gson();
      
        // String json = convertToJson(messages);

        response.setContentType("text/html;");
        response.getWriter().println(json);
        //printRequest(response.getWriter(), request);
    }

    private String convertToJson(ArrayList<String> messages){
        Gson gson = new Gson();
        String json = gson.toJson(messages);
        return json;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the input from the form.
        String message = getMessage(request);
        //String message = request.getMessage("message-container");
        response.setContentType("text/html;"); //
        //System.out.println("do post message");
        messages.add(message);

        Entity messageEnt = new Entity("message");
        messageEnt.setProperty("message-container", message);

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(messageEnt);
        //redirect
        response.sendRedirect("/index.html");

    }

    private String getMessage(HttpServletRequest request){ //, String name, String defaultValue
        String message = request.getParameter("message-container");
        return message;
    }
}
    
   
    // private String convertToJsonUsingGson(DataServlet messages) {
    //     Gson gson = new Gson();
    //     String json = gson.toJson(messages);
    //     return json;
    // }



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
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    //private ArrayList<String> messages
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<String> messages = new ArrayList<String>();
        
        Gson gson = new Gson();
        String json = gson.toJson(messages);
        
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

    //@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the input from the form.
        String messages = message(request);
        //String[] words = text.split("\\s*,\\s*");
        // Respond with the result.
        response.setContentType("text/html;");
        messages.add(message)
        //response.getWriter().println(Arrays.toString(words));


        // String json = convertToJson(comments);
        // response.setContentType("text/html;");
        // response.getWriter().println(json);

    }

    private String getMessage(HttpServletRequest request){
        String comment = request.getParameter("text-input");
        return comment;
    }
}
    
   



//   @Override
//   public void init() {
//     messages = new ArrayList<>();
//     messages.add("1");
//     messages.add("2");
//     messages.add("3");
//   }
  

//   @Override
//   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//     // Convert to JSON
//     String json = convertToJsonUsingGson(messages);

//     //Send response as JSON
//     response.setContentType("application/json;");
//     response.getWriter().println(json);
//   }

    // private String convertToJsonUsingGson(DataServlet messages) {
    //     Gson gson = new Gson();
    //     String json = gson.toJson(messages);
    //     return json;
    // }



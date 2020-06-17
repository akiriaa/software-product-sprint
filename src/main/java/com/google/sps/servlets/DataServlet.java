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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.lang.String;


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    //private ArrayList<String> messages
    ArrayList<String> messages = new ArrayList<String>();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        // Gson gson = new Gson();
        // String json = gson.toJson(messages);
        String json = convertToJson(messages);

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
        response.setContentType("text/html;");
        //System.out.println("do post message");
        messages.add(message);

        //redirect
        response.sendRedirect("/index.html");

    }

    // private String getParameter(HttpServletRequest request, String message, String defaultValue) {
    // String value = request.getParameter(message);
    // if (value == null) {
    //   return defaultValue;
    // }
    // return value;

    private String getMessage(HttpServletRequest request){ //, String name, String defaultValue
        String message = request.getParameter("message-container");
        return message;
    }
}
    
   
/*
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    printRequest(response.getWriter(), request);
  }

  private void printRequest(PrintWriter out, HttpServletRequest request) {
    out.println("request URL: " + request.getRequestURL());
    out.println("<br/>");

    out.println("request URI: " + request.getRequestURI());
    out.println("<br/>");

    out.println("content length: " + request.getContentLength());
    out.println("<br/>");

    out.println("content type: " + request.getContentType());
    out.println("<br/>");

    out.println("protocol: " + request.getProtocol());
    out.println("<br/>");

    out.println("client IP: " + request.getRemoteAddr());
    out.println("<br/>");

    out.println("server name: " + request.getServerName());
    out.println("<br/>");

    out.println("character encoding: " + request.getCharacterEncoding());
    out.println("<br/>");

    out.println("headers:");
    out.println("<ul>");
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      out.print("<li>" + headerName + ": " + request.getHeader(headerName) + "</li>");
    }
    out.println("</ul>");

    out.println("parameters:");
    out.println("<ul>");
    Enumeration<String> parameterNames = request.getParameterNames();
    while (parameterNames.hasMoreElements()) {
      String parameterName = parameterNames.nextElement();
      out.print("<li>" + parameterName + ": " + request.getParameter(parameterName) + "</li>");
    }
    out.println("</ul>");
  }
*/


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



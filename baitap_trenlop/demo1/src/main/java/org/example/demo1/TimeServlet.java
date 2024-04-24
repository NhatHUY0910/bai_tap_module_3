package org.example.demo1;

import java.io.*;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloTimeServlet", value = "/hello-servlet")
public class TimeServlet extends HttpServlet {
//    private String message;

//    public void init() {
//        message = "Hello World!";
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("");
        Date today = new Date();
        writer.println("<h1>" + today + "</h1>");
        writer.println();
    }

    public void destroy() {
    }
}
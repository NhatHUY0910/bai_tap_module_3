package com.case1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginservlet", value = "/accountlogin")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (session.getAttribute("isSignIn") == null) {
            session.setAttribute("isSignIn", false);
        }

        if ((Boolean) session.getAttribute("isSignIn")) {
            request.getRequestDispatcher("customerPage.jsp").forward(request, response);
        } else {
            response.sendRedirect("authing");
        }
    }
}

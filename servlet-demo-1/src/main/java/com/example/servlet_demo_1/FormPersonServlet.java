package com.example.servlet_demo_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/user-form"})
public class FormPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<form action='add-user' method='post'>");
        writer.println("Name:<input type='text' name='name'>");
        writer.println("Age:<input type='text' name='age'>");
        writer.println("Address:<input type='text' name='address'>");
        writer.println("<input type='submit' value='submit'>");
        writer.println("</form>");
    }
}

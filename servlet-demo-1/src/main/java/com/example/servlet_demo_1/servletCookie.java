package com.example.servlet_demo_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/servletCookie1"})
public class servletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("Hello everybody!");

        Cookie cookie = new Cookie("name", "Binh Hu");
        cookie.setMaxAge(10);
        resp.addCookie(cookie);


        Cookie cookie1 = new Cookie("age", "28");
        cookie1.setMaxAge(5);
        resp.addCookie(cookie1);

        writer.close();
    }
}

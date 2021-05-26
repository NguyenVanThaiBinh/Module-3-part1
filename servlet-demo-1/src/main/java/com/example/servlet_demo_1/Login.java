package com.example.servlet_demo_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("<form action='/login' method='post'>");
        writer.println("User Name <input type='text' name='username' >");
        writer.println("Password <input type='password' name='password' >");
        writer.println(" <input type='submit' value='Login'>");
        writer.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("binhhu") && password.equals("12345")) {

            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(30);
            resp.addCookie(cookie);
            resp.sendRedirect("/welcome");
        } else {
            resp.sendRedirect("/login");
        }
    }
}

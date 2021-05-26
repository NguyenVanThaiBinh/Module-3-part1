package com.example.servlet_demo_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/test-request"})
public class RequestServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Request Method is::"+req.getMethod());
        req.getContextPath();
        req.getContentType();
        System.out.println(req.getServletPath());
        System.out.println(req.getServerName());

        

//        Enumeration<String> keys = req.getHeaderNames();
//        while (keys.hasMoreElements()){
//            String key = keys.nextElement();
//            System.out.println(key+" : "+req.getHeader(key));
//        }

    }

}

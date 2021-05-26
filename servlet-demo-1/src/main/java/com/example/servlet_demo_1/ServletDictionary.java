package com.example.servlet_demo_1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletDictionary", value = "/ServletDictionary")
public class ServletDictionary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,String> map = new HashMap<>();
        map.put("banana","Chuối");
        map.put("apple","Táo");
        map.put("blackberry","Dâu đen");
        map.put("pineapple","Dứa");
        String text = request.getParameter("text");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();
        if(map.containsKey(text)){
            writer.println(map.get(text));
        }
        else{
            writer.println("Not Found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

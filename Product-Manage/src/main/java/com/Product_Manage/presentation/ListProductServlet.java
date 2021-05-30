package com.Product_Manage.presentation;


import com.Product_Manage.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/list-form")
public class ListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        int index = Integer.parseInt(request.getParameter("index"));

        if (action.equalsIgnoreCase("delete")) {
           //gọi session về
            HttpSession session = request.getSession(false);
            List<Product> productList = new ArrayList<>();

            if (session.getAttribute("productList") != null) {
                //nếu khác rỗng thì bỏ session vào productList rồi remove
                productList = (List<Product>) session.getAttribute("productList");
                productList.remove(index);
            }
            //sau đó ghi đè lại session
            session.setAttribute("productList", productList);
        }

        response.sendRedirect("list-form");


    }
}
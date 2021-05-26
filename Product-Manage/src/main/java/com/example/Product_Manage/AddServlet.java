package com.example.Product_Manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddServlet", value = "/Add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addProduct.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");

        ProductObject productObject = new ProductObject(name,category,price,description);

        // save product to session

        HttpSession session = request.getSession(false);

        List<ProductObject> productList = new ArrayList<>();

        if(session.getAttribute("productList") !=null){
            productList = (List<ProductObject>) session.getAttribute("productList");
        }
        productList.add(productObject);



        session.setAttribute("productList",productList);


        response.sendRedirect("Add ");

    }
}

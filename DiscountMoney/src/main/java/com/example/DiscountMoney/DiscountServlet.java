package com.example.DiscountMoney;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/discount"})
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        float price = Float.parseFloat(req.getParameter("price"));
        float discount = Float.parseFloat(req.getParameter("discount"));
        String product = req.getParameter("product");

        float amount = (float) (price * discount * 0.01);
        float total = (float) price - amount;

        req.setAttribute("product", product);
        req.setAttribute("price", price);
        req.setAttribute("discount", discount);
        req.setAttribute("amount", amount);
        req.setAttribute("total", total);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/DisplayDiscount.jsp");
        requestDispatcher.forward(req,resp);
//        Discount Amount = List Price * Discount Percent * 0.01

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

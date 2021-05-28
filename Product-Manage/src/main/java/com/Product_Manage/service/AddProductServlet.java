package com.Product_Manage.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.Product_Manage.model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diep
 */
@WebServlet(urlPatterns = {"/add"})

public class AddProductServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = -1;
        if(request.getParameter("id") != null) {
            index = Integer.parseInt(request.getParameter("id"));
        }
        //save product into session
        HttpSession session = request.getSession(false);
        List<Product> productList = new ArrayList<>();

        if(session.getAttribute("productList") != null) {
            productList = (List<Product>) session.getAttribute("productList");
        }
        Product product = new Product();
        if(productList.size() > index && index != -1) {
            product = productList.get(index);
        } else {
            index = -1;
        }
        System.out.println(product);

        request.setAttribute("product", product);
        request.setAttribute("index", index);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        int index = Integer.parseInt(request.getParameter("index"));

        Product product = new Product(name, category, description, price);
        //save product into session
        HttpSession session = request.getSession(false);
        List<Product> productList = new ArrayList<>();

        if(session.getAttribute("productList") != null) {
            productList = (List<Product>) session.getAttribute("productList");
        }
        if(index >= 0) {
            productList.set(index, product);
        } else {
            productList.add(product);
        }

        session.setAttribute("productList", productList);

        response.sendRedirect("add");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


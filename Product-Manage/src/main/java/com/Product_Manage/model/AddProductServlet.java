package com.Product_Manage.model;


import com.Product_Manage.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/add-form")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int index = -1;
        // Khi thêm đầu tiền thì id = null, nên giá trị index = -1
        if(request.getParameter("id") != null) {
            index = Integer.parseInt(request.getParameter("id"));
        }
        //save product into session
        HttpSession session = request.getSession(false);
        List<Product> productList = new ArrayList<>();

        if(session.getAttribute("productList") != null) {
            // bỏ dữ liệu từ session vào productList
            productList = (List<Product>) session.getAttribute("productList");
        }
        // tạo một đối tượng mới
        Product product = new Product();

        // nếu index != -1 thì lôi đầu cái đối tượng mà có index đó ra
        if(productList.size() > index && index != -1) {
            product = productList.get(index);
        } else {
            index = -1;
        }

        // set Attribute cho đối tượng đó và cả index(mặc định index = -1)
        request.setAttribute("product", product);
        request.setAttribute("index", index);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //validate data (make it true)
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        // lấy index về(mặc định là -1)
        int index = Integer.parseInt(request.getParameter("index"));

        HttpSession session = request.getSession(false);
        Product product = new Product(name, email);
        List<Product> productList = null;

        if (session.getAttribute("productList") != null) {
            // đã tồn tại thì gọi session, thì gọi cái session đã lưu về với cái tên productList
            productList = (List<Product>) session.getAttribute("productList");
        } else {
            productList = new ArrayList<>();
        }

        //vì khi action nơi nút Edit xảy ra, lúc đó index sẽ có giá trị
        // nó sẽ nhảy vảo đây gọi hàm set lại product đó qua index trong ProductList
        if(index >= 0) {
            productList.set(index, product);

        } else {
            productList.add(product);
        }

        // cuối cùng lưu lại productList vào session
        session.setAttribute("productList", productList);

        response.sendRedirect("add-form");


    }
}
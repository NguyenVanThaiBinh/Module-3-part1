package servlet;

import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/dang-ky")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //validate data (make it true)
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");


        User user = new User(name,email,password,address,birthday);


        HttpSession session = request.getSession(false);

        session.setAttribute("theLasttestUser",user);

        //save list user registered!!!
        List<User> userList = null;

        if(session.getAttribute("userList") !=null){
            // đã tồn tại thì gọi session, với tên là userList
            userList =(List<User>) session.getAttribute("userList");
        }else {
            userList = new ArrayList<>();
        }
        userList.add(user);
        session.setAttribute("userList",userList);

        response.sendRedirect("dang-nhap");
    }
}

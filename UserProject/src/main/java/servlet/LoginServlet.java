package servlet;

import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/dang-nhap")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("msg","");
       HttpSession session = request.getSession();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // take data from session
        User theLasttestUser = (User) request.getSession().getAttribute("theLasttestUser");



        if(theLasttestUser !=null & email.equalsIgnoreCase(theLasttestUser.getEmail()) && password.equals(theLasttestUser.getPassword())){
            //login success
            HttpSession session = request.getSession(false); //lay sesssion ve
            session.setAttribute("name", theLasttestUser.getName()); // set lai session
            //ôm dữ liệu qua trang welcome luôn
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
            requestDispatcher.forward(request,response);
        }else{
            //login false
            request.setAttribute("msg","Password is fail!!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}

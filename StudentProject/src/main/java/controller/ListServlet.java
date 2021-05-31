package controller;

import dao.studentDAO;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet", value = "/list-student")
public class ListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            default:
                try {
                    listStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        studentDAO studentDAO = new studentDAO();

        List<Student> studentList = studentDAO.selectAllStudent();
        request.setAttribute("studentList",studentList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listStudent.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

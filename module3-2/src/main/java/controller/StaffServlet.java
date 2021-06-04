package controller;

import model.Staff;
import staffDAO.StaffDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "StaffServlet", value = "/staff")
public class StaffServlet extends HttpServlet {
   static StaffDAO staffDAO = new StaffDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
                case "edit":
                    showEditForm(request, response);
                    break;
//
                case "search":
                    try {
                        showSearch(request,response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff existingUser = staffDAO.selectUser(id);
        String editMsg = "";
        request.setAttribute("addMsg",editMsg);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");

        dispatcher.forward(request, response);

    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String keyword = request.getParameter("search");
        List<Staff> userList = staffDAO.searchUsers(keyword);
        request.setAttribute("userList",userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffDAO.deleteUser(id);

        List<Staff> listUser = staffDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> listUser = staffDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addMsg = "";
        request.setAttribute("addMsg",addMsg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String group = request.getParameter("group");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        int phone = Integer.parseInt(request.getParameter("phone"));

        int cmnd = Integer.parseInt(request.getParameter("cmnd"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));

        Staff staff = new Staff(id,group ,name,dob, gender, phone,cmnd,email,address);
        staffDAO.updateUser(staff);
        String editMsg = "Update complete!";
        request.setAttribute("user", staff);
        request.setAttribute("addMsg",editMsg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String group = request.getParameter("group");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        int phone = Integer.parseInt(request.getParameter("phone"));
        int cmnd = Integer.parseInt(request.getParameter("cmnd"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Staff staff = new Staff(group ,name,dob, gender, phone,cmnd,email,address);
        staffDAO.insertUser(staff);
        String addMsg = "Add complete!";
        request.setAttribute("addMsg",addMsg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }
    }


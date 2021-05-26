import com.example.JSP_part_1.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/Student-Manage")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("binh","binhhu@gmail.com","22/10/1998","Hue"));
        studentList.add(new Student("chau","minhminh@gmail.com","22/10/1998","Ha Noi"));
        studentList.add(new Student("minh","chaulau@gmail.com","22/10/1998","Da Nang"));

        request.setAttribute("studentList",studentList);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentList.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

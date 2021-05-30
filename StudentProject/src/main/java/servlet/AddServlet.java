package servlet;

import model.Student;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diep
 */
@WebServlet(urlPatterns = {"/add-student"})
public class AddServlet extends HttpServlet {

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
        Student std = new Student(0);

        if(request.getParameter("id") != null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("StudentProjectPU");
            EntityManager em = factory.createEntityManager();
            int id = Integer.parseInt(request.getParameter("id"));
            std = em.find(Student.class, id);
        }

        request.setAttribute("std", std);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
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
        int id = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        //Save into database
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("StudentProjectPU");
        EntityManager em = factory.createEntityManager();

        if(id == 0) {
            Student std = new Student();
            std.setFullname(name);
            std.setAge(age);
            std.setAddress(address);

            em.getTransaction().begin();
            em.persist(std);
            em.getTransaction().commit();
        } else {
            Student editStd = em.find(Student.class, id);

            em.getTransaction().begin();
            editStd.setFullname(name);
            editStd.setAge(age);
            editStd.setAddress(address);
            em.getTransaction().commit();
        }

        response.sendRedirect("add-student");
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

package Servlet;

import Model.EmployeeDBImp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by cheon on 6/12/16.
 */
public class UpdatePassword extends HttpServlet {
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        String newPassword = request.getParameter("newPassword");
        EmployeeDBImp employeeDBImp = new EmployeeDBImp();
        try {
            employeeDBImp.updatePassword(id, newPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("AccountSet.jsp");
    }
}

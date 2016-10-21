package Servlet;

import Model.Employee;
import Model.EmployeeDBImp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cheon on 6/15/16.
 */
public class Employees extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EmployeeDBImp employeeDBImp = new EmployeeDBImp();
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            employees = employeeDBImp.getEmpInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("GetEmpInfo",employees);
        response.sendRedirect("Show.jsp?type=Employees");
    }
}

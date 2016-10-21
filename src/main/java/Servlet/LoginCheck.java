package Servlet;

import Model.*;

import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cheon on 6/3/16.
 */
public class LoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        if(type.equals("employee")) {
            Employee employee = new Employee(id, password);
            EmployeeDBImp employeeDBImp = new EmployeeDBImp();
            FileDBImp fileDBImp = new FileDBImp();
            ArrayList<File> latestFile = null;
            ArrayList<File> mostDownload = null;
            ArrayList<File> mostBrowse = null;
            try {
                if (employeeDBImp.checkEmployee(employee)) {
                    try {
                        latestFile = fileDBImp.getLatestFile();
                        mostDownload = fileDBImp.MostDownload();
                        mostBrowse = fileDBImp.MostBrowse();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    HttpSession session = request.getSession();
                    session.setAttribute("id", id);
                    session.setAttribute("password", password);
                    session.setAttribute("latestFile", latestFile);
                    session.setAttribute("mostDownload", mostDownload);
                    session.setAttribute("mostBrowse", mostBrowse);
                    Cookie cookieId = new Cookie("id", id);
                    Cookie cookiePassword = new Cookie("password", password);
                    cookieId.setMaxAge(86400);
                    cookiePassword.setMaxAge(86400);
                    response.addCookie(cookieId);
                    response.addCookie(cookiePassword);

                    response.sendRedirect("Main.jsp");
                } else
                    response.sendRedirect("Login.jsp?feedback=Wrong id or password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            Admin admin = new Admin(id,password);
            AdminDBImp adminDBImp = new AdminDBImp();
            try {
                if(adminDBImp.checkAdmin(admin)){
                    HttpSession session = request.getSession();
                    session.setAttribute("aId",id);
                    session.setAttribute("aPassword",password);
                    Cookie cookieAid = new Cookie("aId", id);
                    Cookie cookieApassword = new Cookie("aPassword", password);
                    cookieAid.setMaxAge(86400);
                    cookieApassword.setMaxAge(86400);
                    response.addCookie(cookieAid);
                    response.addCookie(cookieApassword);
                    response.sendRedirect("Amain.jsp");
                }
                else
                    response.sendRedirect("ALogin.jsp?feedback=Wrong id or password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Employee employee = new Employee(id, password);
        EmployeeDBImp employeeDBImp = new EmployeeDBImp();
        FileDBImp fileDBImp = new FileDBImp();
        ArrayList<File> latestFile = null;
        ArrayList<File> mostDownload = null;
        ArrayList<File> mostBrowse = null;
        try {
            if(employeeDBImp.checkEmployee(employee)){
                try {
                    latestFile = fileDBImp.getLatestFile();
                    mostDownload = fileDBImp.MostDownload();
                    mostBrowse = fileDBImp.MostBrowse();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                HttpSession session = request.getSession();
                session.setAttribute("id", id);
                session.setAttribute("password", password);
                session.setAttribute("latestFile", latestFile);
                session.setAttribute("mostDownload", mostDownload);
                session.setAttribute("mostBrowse", mostBrowse);
                response.sendRedirect("Main.jsp");
            }
            else
                response.sendRedirect("Login.jsp?feedback=Wrong id or password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

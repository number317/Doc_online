package Servlet;

import Model.Admin;
import Model.AdminDBImp;

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
public class Admins extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AdminDBImp adminDBImp = new AdminDBImp();
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            admins = adminDBImp.GetAdminInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("GetAdminInfo",admins);
        response.sendRedirect("Show.jsp?type=Admins");
    }
}

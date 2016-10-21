package Servlet;

import Model.File;
import Model.FileDBImp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cheon on 6/11/16.
 */
public class AccountSet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        FileDBImp fileDBImp = new FileDBImp();
        ArrayList<File> files = null;
        try {
            files = fileDBImp.getFileByEmpId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("upload", files);
        response.sendRedirect("AccountSet.jsp");
    }
}

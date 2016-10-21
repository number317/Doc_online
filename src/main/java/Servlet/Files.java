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
 * Created by cheon on 6/15/16.
 */
public class Files extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileDBImp fileDBImp = new FileDBImp();
        ArrayList<File> files = new ArrayList<>();
        try {
            files = fileDBImp.getFileInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("GetFileInfo",files);
        response.sendRedirect("Show.jsp?type=Files");
    }
}

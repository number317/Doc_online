package Servlet;

import Model.EmployeeDBImp;
import Model.FileDBImp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

/**
 * Created by cheon on 6/9/16.
 */
public class View extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        String fileId = request.getParameter("fileId");
        int PerNum = 0, needPerNum =1;
        EmployeeDBImp employeeDBImp = new EmployeeDBImp();
        try {
            PerNum = employeeDBImp.getPerNum(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String file = URLEncoder.encode(request.getParameter("file"),"UTF-8");
        String fileClass = request.getParameter("fileClass");
        FileDBImp fileDBImp = new FileDBImp();
        try {
            needPerNum = fileDBImp.getFilePerNum(fileClass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(PerNum < needPerNum)
            response.sendRedirect("plugins/generic/web/viewer.html?file=../../../Files/Permission.pdf");
        else {
            try {
                fileDBImp.updateBrowseTimes(fileId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("plugins/generic/web/viewer.html?file=../../../Files/" + file);
        }
    }
}

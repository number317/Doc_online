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
 * Created by cheon on 6/5/16.
 */
public class SearchFile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String method = request.getParameter("method");
        String key = request.getParameter("key");
        FileDBImp fileDBImp = new FileDBImp();
        ArrayList<File> files = new ArrayList<>();
        switch (method){
            case "FileName":
                try {
                    files = fileDBImp.getFileByName(key);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "FileType":
                try {
                    files = fileDBImp.getFileByType(key);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "EmpId":
                try {
                    files = fileDBImp.getFileByEmpId(key);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
        int rowCount;
        if(files == null)
            rowCount = 0;
        else
            rowCount = files.size();
        int currentPage = 1;
        int pageSize = 2;
        int pageCount = fileDBImp.getPageCount(rowCount, pageSize);
        HttpSession session = request.getSession();
        session.setAttribute("SearchResult", files);
        session.setAttribute("pageSize", pageSize);
        session.setAttribute("pageCount", pageCount);
        session.setAttribute("rowCount", rowCount);
        response.sendRedirect("FileResult.jsp?currentPage="+currentPage);
    }
}

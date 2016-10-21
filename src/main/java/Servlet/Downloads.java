package Servlet;

import Model.DownloadDBImp;

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
public class Downloads extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DownloadDBImp downloadDBImp = new DownloadDBImp();
        ArrayList<Model.Download> downloads = new ArrayList<>();
        try {
            downloads = downloadDBImp.GetDownloadInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("GetDownloadInfo", downloads);
        response.sendRedirect("Show.jsp?type=Downloads");
    }
}

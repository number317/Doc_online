package Servlet;

import Model.FileDBImp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cheon on 6/14/16.
 */
public class Download extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileId = request.getParameter("fileId");
        HttpSession session = request.getSession();
        String empId = (String)session.getAttribute("id");
        FileDBImp fileDBImp = new FileDBImp();
        try {
            ArrayList<String> info = fileDBImp.getFileInfoById(fileId);
            String fileName = info.get(0);
            String fileType = info.get(1);
            String deptName = info.get(6);
            String fileClassName = info.get(3);
            System.out.println(empId+" "+fileId);
            fileDBImp.insertDownload(empId,fileId,fileName,deptName,fileClassName);
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName+"."+fileType);
            File downloadFile = new File(request.getRealPath("/Files")+"/"+fileId+"/"+fileName+"."+fileType);
            InputStream inputStream = new FileInputStream(downloadFile);
            OutputStream outputStream = response.getOutputStream();
            byte[] b = new byte[1024];
            while(inputStream.read(b)!=-1)
                outputStream.write(b);
            outputStream.flush();
            outputStream.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

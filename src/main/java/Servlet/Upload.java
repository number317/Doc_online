package Servlet;

import Model.EmployeeDBImp;
import Model.FileDBImp;
import Model.OfficeToPdf;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by cheon on 6/12/16.
 */
public class Upload extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart){
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024*1024*5);
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                String fileClassId = null;
                String fileClassName = null;
                while(iter.hasNext()){
                    FileItem item = (FileItem) iter.next();
                    if(item.isFormField()) {
                        fileClassName = item.getString();
                    }
                    else{
                        InputStream uploadStream = item.getInputStream();
                        File uploadFile = new File(item.getName());
                        String path = request.getRealPath("/Files");
                        UUID uuid = UUID.randomUUID();
                        File id = new File(path+"/"+uuid.toString());
                        id.mkdirs();
                        FileOutputStream outputStream = new FileOutputStream(path+"/"+uuid.toString()+"/"+uploadFile.getName());
                        byte[] b = new byte[1024];
                        while(uploadStream.read(b)!=-1)
                            outputStream.write(b);
                        uploadStream.close();
                        outputStream.close();
                        String fileId = uuid.toString();
                        String fileName = uploadFile.getName().split("\\.")[0];
                        String fileType = uploadFile.getName().split("\\.")[1];
                        switch (fileClassName){
                            case "Normal":
                                fileClassId = "00001";
                                break;
                            case "Important":
                                fileClassId = "00002";
                                break;
                            case "Secret":
                                fileClassId = "00003";
                                break;
                        }
                        HttpSession session = request.getSession();
                        EmployeeDBImp employeeDBImp = new EmployeeDBImp();
                        String empId = (String)session.getAttribute("id");
                        String deptId = employeeDBImp.getDeptId(empId);
                        String deptName = employeeDBImp.getDeptName(empId);
                        String filePath = path+"/"+uuid.toString()+"/"+uploadFile.getName();
                        FileDBImp fileDBImp = new FileDBImp();
                        fileDBImp.uploadFile(fileId,fileName,fileType,fileClassId,fileClassName,empId,deptId,deptName,filePath);
                        String sourceFilePath = path+"/"+uuid.toString();
                        String sourceFileName = uploadFile.getName();
                        OfficeToPdf officeToPdf = new OfficeToPdf(sourceFilePath, sourceFileName);
                        officeToPdf.Permission();
                        officeToPdf.ToPdf();
                        response.sendRedirect("AccountSet.jsp");
                    }
                }
            } catch (FileUploadException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

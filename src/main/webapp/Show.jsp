<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.File"%>
<%@ page import="Model.Employee"%>
<%@ page import="Model.Download"%>
<%@ page import="Model.Admin"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
</head>
<body>
<%
    String type = request.getParameter("type");
    switch(type){
        case "Files":
        ArrayList<File> files = (ArrayList<File>)session.getAttribute("GetFileInfo");
        for(int i=0; i<files.size(); i++){
            out.println("<h3>"+files.get(i).getFile_ID()+"  "+files.get(i).getFile_name()+"  "+files.get(i).getFile_type()+"  "+files.get(i).getFile_Dept_ID()+"   "+files.get(i).getFile_Dept_name()+"  "+files.get(i).getFile_Employee_ID()+"   "+files.get(i).getFile_FileClass_ID()+"   "+files.get(i).getFile_FileClass_name()+files.get(i).getUpload_Time()+"   "+files.get(i).getBrowse_Times()+"    "+files.get(i).getUpload_Time()+"<h3>");
        }
        break;
        case "Employees":
        ArrayList<Employee> employees = (ArrayList<Employee>)session.getAttribute("GetEmpInfo");
        for(int i=0; i<employees.size(); i++){
            out.println("<h3>"+employees.get(i).getId()+"   "+employees.get(i).getPassword()+"  "+employees.get(i).getTitleId()+"   "+employees.get(i).getTitleName()+" "+employees.get(i).getDeptId()+"    "+employees.get(i).getDeptName()+"  "+employees.get(i).getPerNum()+"</h3>");
        }
        break;
        case "Downloads":
        ArrayList<Download> downloads = (ArrayList<Download>)session.getAttribute("GetDownloadInfo");
        for(int i=0; i<downloads.size();i++){
            out.println("<h3>"+downloads.get(i).getEmpId()+"    "+downloads.get(i).getFileId()+"    "+downloads.get(i).getDownloadTime().toString()+"   "+downloads.get(i).getFileName()+"  "+downloads.get(i).getDeptName()+"  "+downloads.get(i).getFileClassName());
        }
        break;
        case "Admins":
        ArrayList<Admin> admins = (ArrayList<Admin>)session.getAttribute("GetAdminInfo");
        for(int i=0; i<admins.size();i++){
            out.println("<h3>"+admins.get(i).getId()+"  "+admins.get(i).getPassword());
        }
    }
%>
</body>
</html>
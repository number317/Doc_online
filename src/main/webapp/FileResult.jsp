<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.File"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link href="css/FileResult.css" rel="stylesheet" type="text/css" media="all"/>
    <title>FileResult</title>
</head>
<body>
    <div class="Result">
        <h1>Search Result: <%=(int)session.getAttribute("rowCount")%> records in <%=session.getAttribute("pageCount")%> pages.</h1>
        <%
            int rowCount = (int)session.getAttribute("rowCount");
            int pageSize = (int)session.getAttribute("pageSize");
            int pageCount = (int)session.getAttribute("pageCount");
            int currentPage = Integer.valueOf(request.getParameter("currentPage"));
            out.println("<h2>Current Page: "+ currentPage+"</h2>");
            ArrayList<File> files = (ArrayList<File>)session.getAttribute("SearchResult");
            for(int i = (currentPage-1)*pageSize; i < currentPage*pageSize && i< rowCount; i++){
        %>
        <h4><a href="View.do?fileId=<%=files.get(i).getFile_ID()%>&file=<%=files.get(i).getFile_ID()%>/<%=files.get(i).getFile_name()%>.pdf&fileClass=<%=files.get(i).getFile_FileClass_name()%>" target="blank"><%=files.get(i).getFile_name()%>.<%=files.get(i).getFile_type()%></a></h4>
        <h5>File Class: <%=files.get(i).getFile_FileClass_name()%></h5>
        <h5>Employee ID: <%=files.get(i).getFile_Employee_ID()%></h5>
        <h5>Department Name: <%=files.get(i).getFile_Dept_name()%></h5>
        <h5>Browse Times: <%=files.get(i).getBrowse_Times()%></h5>
        <h5>Download Times: <%=files.get(i).getDownload_Times()%></h5>
        <h5>Upload Time: <%=files.get(i).getUpload_Time()%></h5>

         <div id="View">
        <a target="blank"  href="View.do?fileId=<%=files.get(i).getFile_ID()%>&file=<%=files.get(i).getFile_ID()%>/<%=files.get(i).getFile_name()%>.pdf&fileClass=<%=files.get(i).getFile_FileClass_name()%>">View</a>
        </div>
        <div id="Download">
        <a class="Download"  href="Download.do?fileId=<%=files.get(i).getFile_ID()%>&fileClass=<%=files.get(i).getFile_FileClass_name()%>">Download</a>
        </div>
        <hr align="left" width="800px"/>
        <%
            }
            if(currentPage != 1){
                out.println("<a href=\"FileResult.jsp?currentPage=1\">"+"First"+"</a>");
                out.println("<a href=\"FileResult.jsp?currentPage="+(currentPage-1)+""+"\">"+"prev"+"</a>");
            }
            for(int i = currentPage; i<=currentPage+3 && i<pageCount; i++)
                out.println("<a href=\"FileResult.jsp?currentPage="+(i+1)+""+"\">"+" "+(i+1)+"</a>");
            if(currentPage != pageCount && pageCount != 1){
                out.println("<a href=\"FileResult.jsp?currentPage="+(currentPage+1)+""+"\">"+"next"+"</a>");
                out.println("<a href=\"FileResult.jsp?currentPage="+pageCount+""+"\">"+"Last"+"</a>");
            }
        %>

    </div>
    <div class="Ver_hr">
        <hr width="1px" size="800px"/>
    </div>
</body>
</html>

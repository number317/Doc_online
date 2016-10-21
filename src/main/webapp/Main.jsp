<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.File"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link href="css/Main.css" rel="stylesheet" type="text/css" media="all"/>
    <title>Main</title>
</head>
<body>
	<div class="Account">
		<a href="AccountSet.do"><%=(String)session.getAttribute("id")%></a>
		<a href="Login.jsp"> | Log out</a>
		<a href="LoginCheck.do?id=<%=(String)session.getAttribute("id")%>&password=<%=(String)session.getAttribute("password")%>"> | Refresh</a>
	</div>
    <div class="Search">
		<form action="SearchFile.do" method="get" name="Search">
			<select name="method">
				<option value="FileName">Name</option>
				<option value="FileType">Type</option>
				<option value="EmpId">EmpId</option>
			</select>
			<input type="text" name="key"/>
			<input type="submit" value="Search"/>
		</form>
	</div>
	<div class="Statistics">
	    <hr/>
	    <div class="Latest">
	        <h3>The Latest Files</h3>
	        <%
	            ArrayList<File> latestFile = (ArrayList<File>)session.getAttribute("latestFile");
	            for(int i=0; i<latestFile.size(); i++){
	        %>
	        <h4><a href="View.do?fileId=<%=latestFile.get(i).getFile_ID()%>&file=<%=latestFile.get(i).getFile_ID()%>/<%=latestFile.get(i).getFile_name()%>.pdf&fileClass=<%=latestFile.get(i).getFile_FileClass_name()%>" target="blank"><%=latestFile.get(i).getFile_name()%>.<%=latestFile.get(i).getFile_type()%></a></h4>
	        <h5>Employee ID: <%=latestFile.get(i).getFile_Employee_ID()%></h5>
	        <h5>Upload Time: <%=latestFile.get(i).getUpload_Time()%></h5>
	        <%
	            }
	        %>
	    </div>
	    <div class="MostDownload">
	        <h3>The Most Download Files</h3>
	        <%
	    	    ArrayList<File> mostDownload = (ArrayList<File>)session.getAttribute("mostDownload");
	            for(int i=0; i<mostDownload.size(); i++){
	        %>
	        <h4><a href="View.do?fileId=<%=mostDownload.get(i).getFile_ID()%>&file=<%=mostDownload.get(i).getFile_ID()%>/<%=mostDownload.get(i).getFile_name()%>.pdf&fileClass=<%=mostDownload.get(i).getFile_FileClass_name()%>" target="blank"><%=mostDownload.get(i).getFile_name()%>.<%=mostDownload.get(i).getFile_type()%></a></h4>
            <h5>Employee ID: <%=mostDownload.get(i).getFile_Employee_ID()%></h5>
            <h5>Download Times: <%=mostDownload.get(i).getDownload_Times()%></h5>
	        <%
	            }
	        %>
	    </div>
	    <div class="MostBrowse">
	        <h3>The Most Browse Files</h3>
	        <%
	            ArrayList<File> mostBrowse = (ArrayList<File>)session.getAttribute("mostBrowse");
	            for(int i=0; i<mostBrowse.size(); i++){
	        %>
	        <h4><a href="View.do?fileId=<%=mostBrowse.get(i).getFile_ID()%>&file=<%=mostBrowse.get(i).getFile_ID()%>/<%=mostBrowse.get(i).getFile_name()%>.pdf&fileClass=<%=mostBrowse.get(i).getFile_FileClass_name()%>" target="blank"><%=mostBrowse.get(i).getFile_name()%>.<%=mostBrowse.get(i).getFile_type()%></a></h4>
            <h5>Employee ID: <%=mostBrowse.get(i).getFile_Employee_ID()%></h5>
            <h5>Browse Times: <%=mostBrowse.get(i).getBrowse_Times()%></h5>
	        <%
	            }
	        %>
	    </div>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.File"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <link href="css/AccountSet.css" rel="stylesheet" type="text/css" media="all"/>
    <title>AccountSet</title>
</head>
<body>
    <div class="Setting">
        <div class="Account">
            <h2>Welcome <%=(String)session.getAttribute("id")%></h2>
            <div class="UpdatePassword">
                <h3>Update Password</h3>
                <form action="UpdatePassword.do" method="post">
                    <h5>Input Your New Password</h5>
                    <input type="password" name="newPassword"\><br/>
                    <h5>Input Your New Password Again</h5>
                    <input type="password" name="confirmPassword"\><br/>
                    <input type="submit" value="Update" onClick="this.value='Updating'"/>
                </form>
            </div>
        </div>
        <div class="Upload">
            <h3>Upload File</h3>
            <form action="Upload.do" method="post" enctype="multipart/form-data">
                <select name="fileClassName">
                    <option value="Normal">Normal</option>
                    <option value="Important">Important</option>
                    <option value="Secret">Secret</option>
                </select>
                <input type="file" name="file"/>
                <input type="submit" value="Upload" onClick="this.value='Uploading...'"/>
            </form>
        </div>
        <a class="OwnFile" href="SearchFile.do?method=EmpId&key=<%=session.getAttribute("id")%>" align="left">Check Your Files</a>

    </div>
</body>
</html>
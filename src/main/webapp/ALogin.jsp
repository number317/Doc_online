<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link href="css/Login.css" rel="stylesheet" type="text/css" media="all"/>
    <title>Login</title>
</head>
<body>
<div class="login">
    <img src="images/icon.jpg" alt="Company icon"/>
    <h1>XXX Company</h1>
    <h2>Doc Online</h2>
    <%
        String feedback = request.getParameter("feedback");
        String id = null;
        String password = null;
        if(feedback==null)
            feedback = "";
     	Cookie[] cookies=request.getCookies();
     	if(cookies!=null){
     		for(int i=0;i<cookies.length;i++){
     			Cookie cookie=cookies[i];
     			if(cookie.getName().equals("aId"))
     			    id=cookie.getValue();
     			if(cookie.getName().equals("aPassword"))
     			    password=cookie.getValue();
     		}
     	}
     	if(id==null)
     	    id = "";
     	if(password==null)
     	    password = "";
    %>
    <h4><%=feedback%></h4>
    <form action="LoginCheck.do" method="post" name="login" onSubmit="javascript:return login();">
    <input type="text" name="id" value="<%=id%>"/>
    <input type="password" name="password" value="<%=password%>"/>
    <input type="hidden" name="type" value="administrator">
    <input type="submit" value="Login">
    <a href="plugins/generic/web/viewer.html?file=../../../Files/ForgetPassword.pdf" target="blank">forget Password?</a>
    </form>
</div>
<div class="copyright">
    <p>Copyright &copy; 2016. XXX Company All rights reserved.</p>
</div>
</body>
</html>
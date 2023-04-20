<%@page import="student.management.system.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<!-- <style>
body{
	height: 80vh;
	width:100vw;
	display:flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}
a{

	padding:  5em 1em;
	font-size: :1.3rem;
	border :2px solid #565656;
	border-radius: 50px;
	text-decoration: none;
	color:#303030;
	margin: .5rem
}
h1{
	font-size: 7rem;
	color: 565656;
	
}

</style> -->
<body>


	<%Admin admin=(Admin)session.getAttribute("admin"); 
	if(admin!=null){
	%>
	<h1>Welcome Admin</h1>
	<h3>you can manage Student Data here!!</h3>
	
	<div>
	
		<a href="saveStudent.jsp">Save_Student</a>
		<a href="viewStudens">View_Students</a>
	</div>
	<% }else{
		
		response.sendRedirect("AdminLogIn.jsp");
		
	}%>
	
	
	<div>
	<a href="logout">LogOut</a>
	</div>
	
</body>
</html>
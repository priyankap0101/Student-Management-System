<%@page import="student.management.system.dto.Admin"%>
<%@page import="student.management.system.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- <style>
body {
	display: flex;
	flex-direction: column;
	align-items: center;
}
</style> -->
<body>

	<%
	Admin admin=(Admin)session.getAttribute("admin");
	if(admin!=null){
	
	List<Student> students = (List) request.getAttribute("students");%>

	<h1>Students List</h1>

	<table border="" cellPadding="10px" cellSpacing="0">
		<tr>
			<th>Student_Id</th>
			<th>Student_Name</th>
			<th>Student_Email</th>
			<th>Student_Phone</th>
			<th>Student_Fee</th>
			<th>Update_Student</th>
			<th>Delete_Student</th>
		</tr>
		<%for(Student student : students) {%>
		<tr>
			<td><%=student.getStudentId()%></td>
			<td><%=student.getStudentName()%></td>
			<td><%=student.getStudentEmail()%></td>
			<td><%=student.getStudentPhoneNo()%></td>
			<td><%=student.getStudentFee()%></td>
			<td><a href="updateStudent?studentId=<%=student.getStudentId()%>">Update</a></td>
			<td><a href="deleteStudent?studentId=<%=student.getStudentId()%>">Delete</a></td>
		</tr>
		<%}%>

	</table>
	<div>
		<a href="Dashboard.jsp">Home</a>
	</div>

	<% } else{
	response.sendRedirect("AdminLogIn.jsp");
	}%>

</body>
</html>
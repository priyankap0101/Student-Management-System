<%@page import="student.management.system.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Student student=(Student)request.getAttribute("student"); %>

<form action="saveUpdatedStudent" method="post" >

Id: <input name="studentId" type="text" value= "<%=  student.getStudentId() %>" readonly="readonly">

NAME: <input type="text" name="studentName" value= "<%=  student.getStudentName() %>"> <br><br>

PHONE: <input type="text" name="studentPhone" value= "<%=  student.getStudentPhoneNo() %>"> <br><br>

EMAIL: <input type="email" name="studentEmail" value= "<%=  student.getStudentEmail() %>"> <br><br>

Fee: <input type="text" name="studentFee" value= "<%=  student.getStudentFee() %>" readonly="readonly">

<input type="submit" value="save">
</form>
</body>
</html>
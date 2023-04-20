<%@page import="student.management.system.dto.Admin"%>
<html>
<body>

<% Admin admin= (Admin)session.getAttribute("admin"); 
if(admin!=null){
%>
<form action="save" method="post" >

NAME: <input type="text" name="studentName" placeholder="ENTER STUDENT NAME"> <br><br>

PHONE: <input type="text" name="studentPhone" placeholder="ENTER STUDENT PHONE NUMBER"> <br><br>

EMAIL: <input type="text" name="studentEmail" placeholder="ENTER STUDENT EMAIL"> <br><br>


<input type="submit" value="save">

</form>

<%}else{
	response.sendRedirect("AdminLogIn.jsp");
	}%>

</body>
</html>

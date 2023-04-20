package student.management.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.management.system.dao.AdminDao;
import student.management.system.dao.StudentDao;
import student.management.system.dto.Admin;
import student.management.system.dto.Student;

@WebServlet("/save")
public class SaveStudent extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		Admin admin=(Admin)session.getAttribute("admin");
		
		if(admin!=null)
		{
		String name=req.getParameter("studentName");
		long phone=Long.parseLong(req.getParameter("studentPhone"));
		String email=req.getParameter("studentEmail");
		ServletContext context=getServletContext();
		String fee=context.getInitParameter("StudentFee");
		Double studentFee=Double.parseDouble(fee);
		
		Student student=new Student();
		student.setStudentName(name);
		student.setStudentPhoneNo(phone);
		student.setStudentEmail(email);
		student.setStudentFee(studentFee);
		student.setAdmin(admin);
	
		
		StudentDao dao=new StudentDao();
		
		dao.saveStudent(student);
		
		//after saving stuent assign the student to the related admin
		List<Student> students=admin.getStudents();
		students.add(student);
		
		new AdminDao().updateAdmin(admin);
		resp.sendRedirect("Dashboard.jsp");
		}
		else
		{
			resp.sendRedirect("AdminLogIn.jsp");
		}

	}
}

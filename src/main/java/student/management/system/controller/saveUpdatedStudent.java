package student.management.system.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.management.system.dao.StudentDao;
import student.management.system.dto.Admin;
import student.management.system.dto.Student;

@WebServlet("/saveUpdatedStudent")
public class saveUpdatedStudent extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession httpSession=req.getSession();
		Admin admin=(Admin)httpSession.getAttribute("admin");
		
		if(admin!=null) {
		
		
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		String studentName=req.getParameter("studentName");
		String studentEmail=req.getParameter("studentEmail");
		long studentPhoneNo=Long.parseLong(req.getParameter("studentPhone"));
		double studentFee=Double.parseDouble(req.getParameter("studentFee"));
		
		Student student=new Student();
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		student.setStudentPhoneNo(studentPhoneNo);
		student.setStudentEmail(studentEmail);
		student.setStudentFee(studentFee);
		student.setAdmin(admin);
		
		StudentDao dao=new StudentDao();
		
		dao.updateStudent(student);
		
		List<Student>students=new StudentDao().getAllStudents(admin);
		req.setAttribute("students", students);
		
		req.getRequestDispatcher("viewStudents.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("AdminLogIn.jsp");
		}
		}
}

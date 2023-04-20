package student.management.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.management.system.dao.StudentDao;
import student.management.system.dto.Student;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("studentId");
	
		StudentDao dao=new StudentDao();
		
		Student student=dao.getStudent(Integer.parseInt(id));
		
		req.setAttribute("student", student);
		
		req.getRequestDispatcher("UpdateStudent.jsp").forward(req, resp);
	}
}

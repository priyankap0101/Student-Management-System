package student.management.system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.management.system.dao.StudentDao;
import student.management.system.dto.Admin;
import student.management.system.dto.Student;

@WebServlet("/viewStudens")
public class GetAllStudents  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		Admin admin=(Admin)httpSession.getAttribute("admin");
		
		
		if(admin!=null)
		{
			
		List<Student> students=new StudentDao().getAllStudents(admin);
		req.setAttribute("students",students);
		req.getRequestDispatcher("viewStudents.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("AdminLogIn.jsp");
		}
	}
}

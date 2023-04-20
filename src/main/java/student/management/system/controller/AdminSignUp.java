package student.management.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.management.system.dao.AdminDao;
import student.management.system.dto.Admin;

@WebServlet("/signUp")
public class AdminSignUp extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("adminName");
		String email=req.getParameter("adminEmail");
		String password=req.getParameter("adminPassword");
	
		Admin admin=new Admin();
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setAdminPassword(password);
		
		
		
		AdminDao adminDao=new AdminDao();
		adminDao.AdminSignUp(admin);
		
		req.getRequestDispatcher("AdminLogIn.jsp").forward(req, resp);;
		
		
		
	}
}

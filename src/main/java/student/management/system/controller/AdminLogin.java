package student.management.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.management.system.dao.AdminDao;
import student.management.system.dto.Admin;

@WebServlet("/login")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email=req.getParameter("adminEmail");
		String password=req.getParameter("adminPassword");
	
		

		
		AdminDao adminDao=new AdminDao();
		Admin admin=adminDao.AdminLogIn(email, password);
		
		if(admin!=null)
		{
			HttpSession session=req.getSession();//
			//getSession() will check if there is any previous session started anywhere before in this project for particular browser,
			//if there is no session found a new session object is created or else 
			//the existing session object will be given
			session.setAttribute("admin", admin);
			req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
		}
		else
		{
			resp.sendRedirect("AdminSignUp.jsp");
		}
	}
}

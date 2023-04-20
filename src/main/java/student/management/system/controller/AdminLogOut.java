package student.management.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.management.system.dto.Admin;

@WebServlet("/logout")
public class AdminLogOut extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		Admin admin=(Admin)httpSession.getAttribute("admin");
	
		if(admin!=null)
		{
			httpSession.setAttribute("admin", null);
		}
		else {
			resp.sendRedirect("AdminLogIn.jsp");
		}
		
		resp.sendRedirect("AdminLogIn.jsp");
	}
}

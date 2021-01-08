package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repositories.LoginDAO;

public class FirstServlet extends HttpServlet {
	
	LoginDAO loginDao = new LoginDAO();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String u=req.getParameter("username");
		String p= req.getParameter("password");
		
		if(loginDao.validate(u, p)) {
			
			resp.setStatus(200);
			
			resp.setHeader("Content-Type", "application/json");
			
		}else {
			
			resp.setStatus(400);
			
			RequestDispatcher rd = req.getRequestDispatcher("/Frontend/Login/Login.html");
			
		}
		
		}
	
	

}

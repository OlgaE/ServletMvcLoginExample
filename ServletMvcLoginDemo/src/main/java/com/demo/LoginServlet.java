package com.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userId, password;
		userId = request.getParameter("userID");
		password = request.getParameter("passworD");
		
		LoginService service = new LoginService();
		boolean result = service.authenticate(userId, password);
		
		if(result){
			response.sendRedirect("success.jsp");
			return;
		} else {
			response.sendRedirect("login-failed.jsp");
			return;
		}
	}

}

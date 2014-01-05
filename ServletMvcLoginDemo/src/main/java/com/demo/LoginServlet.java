package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Person;
import com.demo.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userId, password;
		userId = request.getParameter("userID");
		password = request.getParameter("passworD");
		
		LoginService service = new LoginService();
		boolean pass = service.authenticate(userId, password);
		Person person = service.getPersonById(userId);
		
		if(pass && person != null){
			request.setAttribute("user", person);
			//response.sendRedirect("success.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
			dispatcher.forward(request, response);
			return;
		} else {
			response.sendRedirect("login-failed.jsp");
			return;
		}
	}

}

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
			
			// Here we can use session object and then call it from the jsp page,
			// still using response.sendRedirect();
			// In the jsp: <% Person person = (Person) session.getAttribute("user"); %>
			// 
			// request.getSession().setAttribute("user", person);
			// response.sendRedirect("success.jsp");
			
			// This is how to use the same request object:
			RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
			dispatcher.forward(request, response);
			// In the jsp: ${user.firstname }.
			
			return;
		} else {
			response.sendRedirect("login-failed.jsp");
			return;
		}
	}

}

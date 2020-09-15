package com.commerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commerce.manageBean.UserBo;
/*
@WebServlet("/index")
*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBo userBo = new UserBo();
		String email = request.getParameter("email");
		System.out.println(email);
		
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		response.setContentType("text/html");
	}	
}

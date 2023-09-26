package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDao;
import com.DB.DBConnect;
import com.entities.User;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User us = new User();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		UserDao dao = new UserDao(DBConnect.getConnection());
		boolean f= dao.userRegister(us);
		if (f) {
			HttpSession session =request.getSession();
			session.setAttribute("reg_msg", "Registration Successfully..");
			response.sendRedirect("register.jsp");
			
		}
		else
		{
			HttpSession session =request.getSession();
			session.setAttribute("Error_msg", "Registration Failed..");
			response.sendRedirect("register.jsp");
		}
	
	}

}

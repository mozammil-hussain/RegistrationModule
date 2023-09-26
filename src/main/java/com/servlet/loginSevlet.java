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

@WebServlet("/loginSevlet")
public class loginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		UserDao dao =new UserDao(DBConnect.getConnection());
		
		User user = dao.getLogin(email, password);
		
		if(user!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user_ob", user);
			response.sendRedirect("home.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("error_msg", "Invalid email and password");
			response.sendRedirect("login.jsp");
		}
		
		
	}

}

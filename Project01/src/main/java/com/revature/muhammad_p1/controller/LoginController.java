package com.revature.muhammad_p1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.muhammad_p1.daos.UserDaoImpl;
import com.revature.muhammad_p1.models.Users;

public class LoginController {

	public static void login(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
//		String myPath = "/resources/html/login.html"; // /Project01/resources/html/login.html
//		req.getRequestDispatcher(myPath).forward(req, resp);
		
		String myPath = null;
		
		if(!req.getMethod().equals("POST")) {
			myPath = "/index.html";
			req.getRequestDispatcher(myPath).forward(req, resp);
			return;
		}
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// validate user entered correct username & password from DB
//		getUserByUsernameAndPassword(String username, String password)
		 Users user = new UserDaoImpl().getUserByUsernameAndPassword(username, password);
		if(user == null) {
			myPath = "/forwarding/incorrectcredentials";
			req.getRequestDispatcher(myPath).forward(req, resp);
			return;
		}else {
			req.getSession().setAttribute("loggedInUsername", username);
			req.getSession().setAttribute("loggedInPassword", password);
			req.getSession().setAttribute("loggedInRole", user.getRole());
			req.getSession().setAttribute("loggedInRoleId", user.getRoleId());
			req.getSession().setAttribute("loggedInUserInfo", user);
			
//			HttpSession session = req.getSession();
			int userRoleId = (int) req.getSession().getAttribute("loggedInRoleId");
			if (userRoleId == 2) {
			myPath = "/master/home";
			req.getRequestDispatcher(myPath).forward(req, resp);
			return;}
			else {
				myPath = "/master/EmployeeHome";
				req.getRequestDispatcher(myPath).forward(req, resp);
				return;
			}
		}
	}
}

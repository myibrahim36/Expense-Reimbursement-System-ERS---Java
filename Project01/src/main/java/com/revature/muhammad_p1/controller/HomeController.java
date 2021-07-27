package com.revature.muhammad_p1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * My Home page Controller
 * @author yasin
 *
 */
public class HomeController {
	
	public static void home(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String myPath = "/resources/html/home.html";
		req.getRequestDispatcher(myPath).forward(req, resp);
	}
	
	public static void EmployeeH(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String myPath = "/resources/html/ehome.html";
		req.getRequestDispatcher(myPath).forward(req, resp);
	}
}

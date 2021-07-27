package com.revature.muhammad_p1.controller;

import java.io.IOException;

/**
 *  Controller for sending from landing page to log in page
 * @author yasin
 *
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoSignInController {

	public static void goSignIn(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String myPath = "/resources/html/login.html";
		req.getRequestDispatcher(myPath).forward(req, resp);
	}
}

package com.revature.muhammad_p1.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.muhammad_p1.controller.GoSignInController;
import com.revature.muhammad_p1.controller.HomeController;
import com.revature.muhammad_p1.controller.LoginController;
import com.revature.muhammad_p1.controller.ReimbursementController;
import com.revature.muhammad_p1.controller.UsersController;

public class Dispatcher {

	public static void myVirtualRouter(HttpServletRequest req, HttpServletResponse resp) 
			throws JsonProcessingException, IOException, ServletException {
		System.out.println("\n\t\tIn MyDispatcher (myVirtualRouter())");
		System.out.println("Current URL: " + req.getRequestURL());
		System.out.println("Current URI: " + req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/Project01/master/login": // coming from landing page to login
		case "/Project01/forwarding/login":
			System.out.println("case 1");
			LoginController.login(req, resp);
			break;
		case "/Project01/master/sign-in": // from successful login to home page
		case "/Project01/forwarding/sign-in":
			System.out.println("case 2");
			GoSignInController.goSignIn(req, resp);
			break;
		case "/Project01/master/home": // from successful login to home page
		case "/Project01/forwarding/home":
			System.out.println("case 3");
			HomeController.home(req, resp);
			break;
		case "/Project01/json/users": // from successful login to home page
			System.out.println("case 4");
			UsersController.allUsersTickets(req, resp);
			break;
		case "/Project01/json/getCurrentUsers": // from successful login to home page
			System.out.println("case 5");
			UsersController.getCurrentUsers(req, resp);
			// to fetch the user's information from their session
			break;
		case "/Project01/json/getMyTickets": // from successful login to home page
			System.out.println("case 6");
			UsersController.getAllMyTickets(req, resp);
			// to fetch the user's information from their session
			break;
		case "/Project01/json/postNewTicket": // from successful login to home page
			System.out.println("case 7");
			ReimbursementController.postNewTix(req, resp);
			System.out.println("are you firing?");
			// to fetch the user's information from their session
			break;
		case "/Project01/master/EmployeeHome": // from successful login to home page
		case "/Project01/forwarding/EmployeeHome":
			System.out.println("case 8");
			HomeController.EmployeeH(req, resp);
		case "/Project01/forwarding/UpdateTicketStatus":
			System.out.println("case 9"); 
			ReimbursementController.updateTix(req, resp);
			break;
		default:
			System.out.println("You've entered a bad URI.");
			req.getRequestDispatcher("/resources/html/badlogin.html").forward(req, resp);
			return;
		}

	}
}

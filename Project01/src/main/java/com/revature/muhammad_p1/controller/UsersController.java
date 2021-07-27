package com.revature.muhammad_p1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.muhammad_p1.models.Reimbursement;
import com.revature.muhammad_p1.models.Users;
import com.revature.muhammad_p1.services.UserService;
import com.revature.muhammad_p1.services.UserServiceImpl;

public class UsersController {
	
	static UserService myUserService =  new UserServiceImpl();

	public static void userFinder(HttpServletRequest req, HttpServletResponse resp) 
			throws JsonProcessingException, IOException {
		// the line below is where we go to the database and not hardcoding
//		Users myUser = myUserService.getUsernameAndPassword(null, null)
		Users myUser = new Users("Jason","pass12");
		
		PrintWriter printer = resp.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myUser)); // ObjectMapper is for converting Json 
	}
	
	public static void allUsersTickets(HttpServletRequest req, HttpServletResponse resp) 
		throws IOException, JsonProcessingException {
		
//		UserService myUser =  new UserServiceImpl();
		List<Reimbursement> myReimbList = myUserService.getAllTickets();
		
		PrintWriter printer = resp.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myReimbList));
	}
	
	public static void getCurrentUsers(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {
		HttpSession session = req.getSession();
		
//		Users myUser = myUserService.getUsernameAndPassword(null, null);
		String userName = (String) req.getSession().getAttribute("loggedInUsername");
		String userRole = (String) req.getSession().getAttribute("loggedInRole");
//		Users myUser = new Users(userName, userRole);
		Users myUser = (Users) session.getAttribute("loggedInUserInfo");
		
		PrintWriter printer = resp.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myUser));
	}
	
	public static void getAllMyTickets(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{

		Users myUser = (Users) req.getSession().getAttribute("loggedInUserInfo");
		List<Reimbursement> employeeTickets = myUserService.viewTicketByUser(myUser);
		
		PrintWriter printer = resp.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(employeeTickets));
	}
}

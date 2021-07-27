package com.revature.muhammad_p1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.muhammad_p1.daos.UserDaoImpl;
import com.revature.muhammad_p1.models.Reimbursement;

public class ReimbursementController {
	public static void ReimbursementFinder(HttpServletRequest req, HttpServletResponse resp) 
			throws JsonProcessingException, IOException {
		Reimbursement myReimb = new Reimbursement();
		
		PrintWriter printer = resp.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myReimb)); // ObjectMapper is for converting Json 
	}
	
	
	public static void postNewTix(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		Reimbursement myReimb = new Reimbursement();
		
		ObjectMapper myObjMapper = new ObjectMapper();
		
		myReimb = myObjMapper.readValue(req.getInputStream(), Reimbursement.class);
		
		new UserDaoImpl().addReimbursement(myReimb);
		
//		System.out.println("from inside controller post tix");
	}
	
	public static void updateTix(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		Reimbursement myReimb = new Reimbursement();
		
		ObjectMapper myObjMapper = new ObjectMapper();
		
		myReimb = myObjMapper.readValue(req.getInputStream(), Reimbursement.class);
		
//		new UserDaoImpl().addReimbursement(myReimb);
		new UserDaoImpl().requestApprovalUpdate(myReimb);;
		
//		System.out.println("from inside controller post tix");
	}
}

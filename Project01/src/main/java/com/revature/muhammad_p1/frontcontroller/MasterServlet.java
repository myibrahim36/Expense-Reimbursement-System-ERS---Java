package com.revature.muhammad_p1.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("MASTER SERVELET: In doGet Method");
		
		Dispatcher.myVirtualRouter(req, resp); // we are offloading the work to the dispatcher here
		
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		System.out.println("MASTER SERVELET: In doPost Method");
		
		doGet(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		System.out.println("MASTER SERVLET: In doPut Method");
		
		doGet(req, resp);
	}
}

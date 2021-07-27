package com.revature.muhammad_p1;

import com.revature.muhammad_p1.daos.UserDaoImpl;
import com.revature.muhammad_p1.daos.UsersDao;
import com.revature.muhammad_p1.models.Reimbursement;
import com.revature.muhammad_p1.models.Users;

public class Driver {

	public static void main(String[] args) {
		// TESTING MY DAO CONNECTIONS/RESULTS HERE

		Users myUser = new Users("John");
		
		Reimbursement newReimbursement = new Reimbursement(5,2025, "test2", 1, 2,3);
	
		Reimbursement newReimbursement2 = new Reimbursement(750, "Java Certification", 3, 1,3);
		
		System.out.println("Hello World!");
		
		UsersDao userDao = new UserDaoImpl();
		
//		userDao.addReimbursement(newReimbursement2);
//		userDao.requestApprovalUpdate(newReimbursement);
		
//		System.out.println("confirm login");
//		System.out.println(userDao.getUserByUsernameAndPassword("John", "pass"));
//		System.out.println("confirm login\n");
//		System.out.println(userDao.viewAllTickets());
//		System.out.println("confirm viewing ALL tickets\n\n");
//		System.out.println(userDao.viewTicketByUser(myUser));
//		System.out.println("confirm all users tickets\n");
	}

}

package com.revature.muhammad_p1.services;

import java.util.List;

import com.revature.muhammad_p1.daos.UserDaoImpl;
import com.revature.muhammad_p1.daos.UsersDao;
import com.revature.muhammad_p1.models.Reimbursement;
import com.revature.muhammad_p1.models.Users;

public class UserServiceImpl implements UserService {

	UsersDao myUserDao = new UserDaoImpl();
	
	@Override
	public List<Reimbursement> getAllTickets() {
		return myUserDao.viewAllTickets();
	}

	@Override
	public Users getUsernameAndPassword(String username, String password) {
		
		return myUserDao.getUserByUsernameAndPassword(username, password);
	}

	@Override
	public List<Reimbursement> viewTicketByUser(Users myUser) {
		
		return myUserDao.viewTicketByUser(myUser);
	}

	@Override
	public void addReimbursement(Reimbursement newTicket) {
		// TODO Auto-generated method stub
		
	}
	

	
	

}

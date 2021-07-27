package com.revature.muhammad_p1.services;

import java.util.List;

import com.revature.muhammad_p1.daos.UserDaoImpl;
import com.revature.muhammad_p1.daos.UsersDao;
import com.revature.muhammad_p1.models.Reimbursement;
import com.revature.muhammad_p1.models.Users;

public interface UserService {
	
	
	public List<Reimbursement> getAllTickets();
	public Users getUsernameAndPassword(String username, String password);
	public List<Reimbursement> viewTicketByUser(Users myUser);
	public void addReimbursement(Reimbursement newTicket);
	
}

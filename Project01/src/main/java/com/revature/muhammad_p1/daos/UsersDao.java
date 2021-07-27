package com.revature.muhammad_p1.daos;

import java.util.List;

import com.revature.muhammad_p1.models.Reimbursement;
import com.revature.muhammad_p1.models.Users;

public interface UsersDao {

	// CREATE
	public void addReimbursement(Reimbursement user);		// user adds new tickets that status is automatically pending
	
	
	// READ
	public Users getUserByUsernameAndPassword(String username, String password);	// login 
	public List<Users> getAllUsers();
	public List<Reimbursement> viewAllTickets();		// only managers can see
	public List<Reimbursement> viewTicketByUser(Users user);		// view only past tickets that have been approved or denied
//	public List<Reimbursement> viewCurrentTickets(Users user);		// each employee viewing their current tickets .. approved, denied, pending

	
	// UPDATE
	public void requestApprovalUpdate(Reimbursement ticket);		// manager can approve, deny new request..  
	
	
	
}

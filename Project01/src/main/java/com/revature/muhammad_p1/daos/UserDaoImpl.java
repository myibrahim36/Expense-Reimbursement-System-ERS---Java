package com.revature.muhammad_p1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.muhammad_p1.models.Reimbursement;
import com.revature.muhammad_p1.models.Users;

public class UserDaoImpl implements UsersDao {

//	final static Logger loggy = Logger.getLogger(UserDaoImpl.class);
//
//	{
//		loggy.setLevel(Level.ALL);
//	}

	@Override
	public Users getUserByUsernameAndPassword(String username, String password) {

		Users user = null;
		try (Connection conn = CustomConnectionFactory.getConnection()) {

//			String sql = "SELECT eu.ers_username, eu.ers_password FROM ers_users eu WHERE ers_username = ? AND ers_password = ?;";
			String sql = "SELECT eu.ers_users_id, eu.ers_username, eu.user_first_name,eu.user_last_name, eu.user_email, eur.user_role, eu.user_role_id FROM ers_users eu \r\n"
					+ "	INNER JOIN ers_user_roles eur ON eu.user_role_id = eur.ers_user_role_id \r\n"
					+ "	WHERE ers_username = ? AND ers_password = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new Users(
						rs.getInt("ers_users_id"),
						rs.getString("ers_username"),
//						rs.getString("ers_password"),
						rs.getString("user_first_name"), 
						rs.getString("user_last_name"), 
						rs.getString("user_email"),
						rs.getString("user_role"), // NEED TO FIX
						rs.getInt("user_role_id")
				);
			}

		} catch (SQLException e) {
//			loggy.error("An SQL exception was thrown: ",e);
			System.out.println("Error While Trying To Obtain User By Username and Password" + e);
		}

		return user;
	}

	@Override
	public List<Reimbursement> viewAllTickets() {
		List<Reimbursement> users = new ArrayList<>();

		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT eur.reimb_id, eu.user_first_name,eu.user_last_name,eur.reimb_amount,es.reimb_status, eur.reimb_submitted, eur.reimb_description \r\n"
					+ "FROM ers_reimbursement eur INNER JOIN ers_users eu \r\n"
					+ "ON eur.reimb_author = eu.ers_users_id \r\n"
					+ "INNER JOIN ers_reimbursement_status es ON  eur.reimb_status_id = es.reimb_status_id;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

//			Reimbursement nextEntry;
			while (rs.next()) {
				users.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getDouble("reimb_amount"), rs.getString("reimb_status"),
						rs.getTimestamp("reimb_submitted"), rs.getString("reimb_description")));

			}
		} catch (SQLException e) {
			System.out.println("Error While Trying To View All Tickets" + e);
		}
		return users;
	}

	/**
	 * view each user viewing all their tickets
	 */
	@Override
	public List<Reimbursement> viewTicketByUser(Users myUser) {
		List<Reimbursement> users = new ArrayList<>();

		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT eur.reimb_id, eu.user_first_name,eu.user_last_name,eur.reimb_amount,es.reimb_status, eur.reimb_submitted, eur.reimb_description \r\n"
					+ "FROM ers_reimbursement eur INNER JOIN ers_users eu \r\n"
					+ "ON eur.reimb_author = eu.ers_users_id \r\n"
					+ "INNER JOIN ers_reimbursement_status es ON  eur.reimb_status_id = es.reimb_status_id\r\n"
					+ "WHERE eu.ers_username = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, myUser.getUsername());

			ResultSet rs = ps.executeQuery();

//			Reimbursement nextEntry;
			while (rs.next()) {
				users.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getDouble("reimb_amount"), rs.getString("reimb_status"),
						rs.getTimestamp("reimb_submitted"), rs.getString("reimb_description")));

			}
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("Error While Trying To View Ticket By User" + e);
		}
		return users;
	}

	
	@Override
	public void addReimbursement(Reimbursement newTicket) {

try (Connection conn = CustomConnectionFactory.getConnection()) {
			
			String sql = "INSERT INTO ers_reimbursement (reimb_amount,reimb_description,reimb_author,reimb_status_id,reimb_type_id)\r\n"
					+ "	VALUES (?,?,?,1,?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newTicket.getReimbAmount());
			ps.setString(2, newTicket.getReimbDescription());
			ps.setInt(3, newTicket.getReimbAuthor());
//			ps.setInt(4, newTicket.getReimbStatusId());
			ps.setInt(4, newTicket.getReimbTypeId());
			
			
//			System.out.println("from inside DAO are you firing?");
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("Error While Trying To Add New Ticket " + e);
		}

	}

	@Override
	public void requestApprovalUpdate(Reimbursement ticket) {
		try (Connection conn = CustomConnectionFactory.getConnection()) {
			
			String sql = "UPDATE ers_reimbursement \r\n"
					+ "SET reimb_resolved = current_date, reimb_resolver = ?, reimb_status_id = ?\r\n"
					+ "WHERE reimb_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticket.getReimbResolver());
			ps.setInt(2, ticket.getReimbStatusId());
			ps.setInt(3, ticket.getId());
			
			
			ps.executeUpdate();
			

			
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("Error While Trying To Update Ticket Status" + e);
		}

	}

	@Override
	public List<Users> getAllUsers() {

		try(Connection conn = CustomConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM ers_users eu;";
			
		}catch(SQLException e) {
			System.out.println("Error while trying to get all users " + e);
		}
		
		return null;
	}




}

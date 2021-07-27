package com.revature.muhammad_p1.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomConnectionFactory {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Static block has failed me");
		}
	}

	public static String url = "jdbc:postgresql://datakun.cmsca4aqlrnw.us-east-1.rds.amazonaws.com/Project1";
	public static String username = "datakun";
	public static String password = "p4ssw0rd";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
}

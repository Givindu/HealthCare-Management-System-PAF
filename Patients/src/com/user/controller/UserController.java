package com.user.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.user.model.User;
import com.user.utill.DBConnection;

public class UserController {
	
	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	
	public String AddUser(User user) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			 if (connection == null)
			 {return "Error while connecting to the database for inserting."; } 
			
			ps = connection.prepareStatement(
					"INSERT INTO  user (`userId`,`firstName`,`lastName`,`userAddress`,`contactNumber`,`userDOB`,`userAge`,`userEmail`) "
							+ "	VALUES (?,?,?,?,?,?,?,?)");

			ps.setInt(1, 0);
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getUserAddress());
			ps.setInt(5, user.getContactNumber());
			ps.setDate(6, user.getUserDOB());
			ps.setInt(7, user.getUserAge());
			ps.setString(8, user.getUserEmail());


			ps.execute();
			 connection.close();
			 output = "Inserted successfully"; 

		}
		 catch (Exception e)
		 {
		 output = "Error while inserting the Users.";
		 System.err.println(e.getMessage());
		 }
		 return output; 

		
	}
	

	//
	public List<User>  readUser() {
		List<User> users = new ArrayList<>();
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				System.err.println("connecting failed.");
			}
			// Prepare the html table to be displayed
			

			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user");
			

			// iterate through the rows in the result set
			while (rs.next()) {
				User use = new User();
				use.setUserId(rs.getInt("userId"));
				use.setFirstName(rs.getString("firstName"));
				use.setLastName(rs.getString("lastName"));
				use.setUserAddress(rs.getString("userAddress"));
				use.setContactNumber(rs.getInt("contactNumber"));
				use.setUserDOB(rs.getDate("userDOB"));
				use.setUserAge(rs.getInt("userAge"));
				use.setUserEmail(rs.getString("userEmail"));




				users.add(use);
			}
			connection.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return users;

	}
	
	public String updateUser(User user) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			ps = connection.prepareStatement(
					"UPDATE user SET firstName=?,lastName=?,userAddress=?,contactNumber=?,userDOB=?,userAge=?,userEmail=? WHERE userId=?");

			// binding values
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3,user.getUserAddress());
			ps.setInt(4, user.getContactNumber());
			ps.setDate(5, user.getUserDOB());
			ps.setInt(6, user.getUserAge());
			ps.setString(7, user.getUserEmail());
			ps.setInt(8, user.getUserId());


			// execute the statement
			ps.execute();
			connection.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the user.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String deleteUser(String userId) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			connection = DBConnection.getConnection();
			ps = connection.prepareStatement("delete from user where userId=?");
			// binding values
			ps.setInt(1, Integer.parseInt(userId));
			// execute the statement
			ps.execute();
			connection.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the user. -"+ e.getMessage();
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	
	
	
	
	
	
	
	

}

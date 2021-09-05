package com.user.service;

import java.sql.Date;
import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.user.controller.UserController;
import com.user.model.User;



@Path("/User")
public class UserService {
	
	
UserController usercontroller = new UserController();
	

	@GET
	@Path("/read")
	@Produces(MediaType.TEXT_PLAIN)
	public String readItems() {
		return new Gson().toJson(usercontroller.readUser());
		//
	}
	

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("userAddress") String userAddress,
			@FormParam("contactNumber") String contactNumber,
			@FormParam("userDOB") String userDOB,
			@FormParam("userAge") String userAge,
			@FormParam("userEmail") String userEmail) throws ParseException {

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserAddress(userAddress);
		user.setContactNumber(Integer.parseInt(contactNumber));
		user.setUserDOB(Date.valueOf(userDOB));
		user.setUserAge(Integer.parseInt(userAge));
		user.setUserEmail(userEmail);
		
		return usercontroller.AddUser(user);
	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@PathParam("id")String userId) {

		return usercontroller.deleteUser(userId);
	}
	

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(@FormParam("userId") String userId,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("userAddress") String userAddress,
			@FormParam("contactNumber") String contactNumber,
			@FormParam("userDOB") String userDOB,
			@FormParam("userAge") String userAge,
			@FormParam("userEmail") String userEmail) throws ParseException {

		User user = new User();
		user.setUserId(Integer.parseInt(userId));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserAddress(userAddress);
		user.setContactNumber(Integer.parseInt(contactNumber));
		user.setUserDOB(Date.valueOf(userDOB));
		user.setUserAge(Integer.parseInt(userAge));
		user.setUserEmail(userEmail);

		return usercontroller.updateUser(user);
	}

	
	
	
	
	

}

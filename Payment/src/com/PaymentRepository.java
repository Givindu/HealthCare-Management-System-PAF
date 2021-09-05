package com;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/payment")

public class PaymentRepository {
	@GET
	@Path("/paymentdetails")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ArrayList<PaymentDetails> getAllPayment() throws Exception
	{
		PaymentResource handler = new PaymentResource();
		return handler.getAllPayment();
	}
	
	@GET
	@Path("payment/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public PaymentDetails getFromId(@PathParam("id") int id) throws SQLException
	{
		PaymentResource handler = new PaymentResource();
		return handler.getPaymentDetails(id);
	}

	@POST
	@Path("/insetpayment")
	public String inerstPayment(PaymentDetails p) throws SQLException
	{
		PaymentResource handler = new PaymentResource();
		String s = handler.insertPaymentDetails(p);
		
		return s;
	}

	@DELETE
	@Path("/deletepayment/{id}")
	public String deletePayment(@PathParam("id") int id) throws SQLException
	{
		PaymentResource handler = new PaymentResource();
		String s = handler.deletePaymentDetails(id);
		return s;
	}
	
	@PUT
	@Path("/updatepayment")
	public String updatePayment(PaymentDetails p) throws SQLException
	{
		PaymentResource handler = new PaymentResource();
		String s = handler.updatePaymentDeails(p);
		return s;
	}

}

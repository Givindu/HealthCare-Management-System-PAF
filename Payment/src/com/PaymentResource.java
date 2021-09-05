package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import util.connection;


public class PaymentResource {
	
	public ArrayList<PaymentDetails> getAllPayment() throws SQLException
	{
		ArrayList<PaymentDetails> list = new ArrayList();
		String qry = "SELECT * FROM payment";
		connection conn = new connection();
		ResultSet rs = conn.getRs(qry);
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 	
			
			while(rs.next())
			{
				PaymentDetails p = new PaymentDetails();
				p.setPayid(rs.getInt(1));
				p.setPaytype(rs.getString(2));
				p.setAmount(rs.getDouble(3));
				Date date = rs.getDate(4);
				p.setDate(dateFormat.format(date));
				
				
				list.add(p);
			}
			conn.con.close();
			return list;
			
	}

	public PaymentDetails getPaymentDetails(int id) throws SQLException
	{
		String qry = "SELECT * FROM `payment`WHERE Payid = "+id+"";
		connection conn = new connection();
		ResultSet resultsets = conn.getRs(qry);
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 
		PaymentDetails pd = new PaymentDetails();
		
		while(resultsets.next())
		{
			
			pd.setPayid(resultsets.getInt(1));
			pd.setPaytype(resultsets.getString(2));
			pd.setAmount(resultsets.getDouble(3));
			Date date = resultsets.getDate(4);
			pd.setDate(dateFormat.format(date));
			
		}
		conn.con.close();
		
		return pd;
	}
	
	public String insertPaymentDetails(PaymentDetails pd) throws SQLException
	{
		connection conn = new connection();
		String sql = "INSERT INTO `payment`(`paytype`, `amount`) VALUES (?,?)";
		PreparedStatement prep = conn.getPs(sql);
		
		prep.setString(1, pd.getPaytype());
		prep.setDouble(2, pd.getAmount());
		
		if(!prep.execute())
		{
			conn.con.close();
			return "successfully inserted";
		}
		else
		{
			conn.con.close();
			return "insertion unsuccessful";
		}
		
		
	}

	public String deletePaymentDetails(int id) throws SQLException
	{
		connection conn = new connection();
		String qry = "DELETE FROM `payment` WHERE Payid = ?";
		PreparedStatement prep = conn.getPs(qry);
		
		prep.setInt(1,id);
		
		if(!prep.execute())
		{
			conn.con.close();
			return  "deleted";
		}
		else
		{
			conn.con.close();
			return  "unsuccessful";
		}
	}
	
	public String updatePaymentDeails(PaymentDetails pd)throws SQLException
	{
		connection conn = new connection();
		String sql = "UPDATE `payment` SET `paytype`=?,`amount`=?  WHERE `id`=";
	    PreparedStatement prep = conn.getPs(sql);
	    prep.setString(1, pd.getPaytype());
	    prep.setDouble(2, pd.getAmount());
	    prep.setInt(3,pd.getPayid());
	    
	    if(!prep.execute())
	    {
			conn.con.close();
			return "Updated";
	    }
	    else
	    {
			conn.con.close();
			return "Unsuccessful";
	    }
	}
}
 
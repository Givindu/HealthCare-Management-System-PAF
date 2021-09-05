package AmbulanceService.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class Ambulance {
	private int Amb_ID;
	private int H_ID;
	private int Admin_Id;
	private String Amb_No;
	private int Amb_Cont;
	private String Driver_Name;
	private Date Ride_Date;

	
	public int getAmb_ID() {
		return Amb_ID;
	}
	public void setAmb_ID(int amb_ID) {
		Amb_ID = amb_ID;
	}
	public int getH_ID() {
		return H_ID;
	}
	public void setH_ID(int h_ID) {
		H_ID = h_ID;
	}
	public int getAdmin_Id() {
		return Admin_Id;
	}
	public void setAdmin_Id(int admin_Id) {
		Admin_Id = admin_Id;
	}
	public String getAmb_No() {
		return Amb_No;
	}
	public void setAmb_No(String amb_No) {
		Amb_No = amb_No;
	}
	public int getAmb_Cont() {
		return Amb_Cont;
	}
	public void setAmb_Cont(int amb_Cont) {
		Amb_Cont = amb_Cont;
	}
	public String getDriver_Name() {
		return Driver_Name;
	}
	public void setDriver_Name(String driver_Name) {
		Driver_Name = driver_Name;
	}
	public Date getRide_Date() {
		return Ride_Date;
	}
	public void setRide_Date(Date ride_Date) {
		Ride_Date = ride_Date;
	}

		
	}
	
	
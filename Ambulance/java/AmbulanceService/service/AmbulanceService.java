package AmbulanceService.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
import AmbulanceService.controller.AmbulanceController;
import AmbulanceService.model.Ambulance;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Ambulance")

public class AmbulanceService {

	AmbulanceController ambulanceController = new AmbulanceController();

	@GET
	@Path("/read")
	@Produces({ MediaType.TEXT_PLAIN })
	public String readItems() {
		return new Gson().toJson(ambulanceController.readAmbulance());
	}

	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAmbulance(@FormParam("H_ID") String H_ID,@FormParam("Admin_Id") String Admin_Id,@FormParam("Amb_No") String Amb_No,@FormParam("Amb_Cont") String Amb_Cont,@FormParam("Driver_Name") String Driver_Name,@FormParam("Ride_Date") String Ride_Date)throws ParseException{

		Ambulance ambulance = new Ambulance();
		ambulance.setH_ID(Integer.parseInt(H_ID));
		ambulance.setAdmin_Id(Integer.parseInt(Admin_Id));
		ambulance.setAmb_No(Amb_No);
		ambulance.setAmb_Cont(Integer.parseInt(Amb_Cont));
		ambulance.setDriver_Name(Driver_Name);
		ambulance.setRide_Date(Date.valueOf(Ride_Date));
		
		return ambulanceController.AddAmbulance(ambulance);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAmbulance(@PathParam("id")String Amb_ID) {

		return ambulanceController.deleteAmbulance(Amb_ID);
	}
	
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAmbulance(@FormParam("Amb_ID") String Amb_ID,@FormParam("H_ID") String H_ID,@FormParam("Admin_Id") String Admin_Id,@FormParam("Amb_No") String Amb_No,@FormParam("Amb_Cont") String Amb_Cont,@FormParam("Driver_Name") String Driver_Name,@FormParam("Ride_Date") String Ride_Date) throws ParseException {

		Ambulance ambulance = new Ambulance();
		ambulance.setAmb_ID(Integer.parseInt(Amb_ID));
		ambulance.setH_ID(Integer.parseInt(H_ID));
		ambulance.setAdmin_Id(Integer.parseInt(Admin_Id));
		ambulance.setAmb_No(Amb_No);
		ambulance.setAmb_Cont(Integer.parseInt(Amb_Cont));
		ambulance.setDriver_Name(Driver_Name);
		ambulance.setRide_Date(Date.valueOf(Ride_Date));
	

		return ambulanceController.updateAmbulance(ambulance);
	}
	
	

}

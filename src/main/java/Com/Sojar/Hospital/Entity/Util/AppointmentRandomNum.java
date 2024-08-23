package Com.Sojar.Hospital.Entity.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AppointmentRandomNum {
	
	
	
	
	public static String appointmentRandomNumberId() {
		
		LocalDateTime now = LocalDateTime.now();   // now means start date time
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMMdd");  // ofpattern method use
		
		String dateTime =now.format(dateFormatter); // format method store  datetimeformatter
		
		
		Random random = new Random();
		
		int i=random.nextInt(9999)+100;   // new int i  random.method create number
		
		String appointmentId =dateTime+i; // String dateTime + i; return store appointmentId
		
		System.out.println(appointmentId);  
		
		
		
		return appointmentId;       // return
	}

}

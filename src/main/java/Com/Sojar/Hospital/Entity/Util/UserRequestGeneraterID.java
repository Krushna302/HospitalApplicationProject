package Com.Sojar.Hospital.Entity.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;



public class UserRequestGeneraterID {
	
	
	
	
	public static String generaterUseNumId() {
		
		LocalDateTime  now =  LocalDateTime.now();
		
		// DateTime Formatter Object in the ofPattern() Method
		 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMdd");
		
		 String dateString = now.format(dateTimeFormatter); // format Method Store dateTime
		 
		 
		 Random random = new Random();
		 
		int i = random.nextInt(9999)+100; //random refer in the nextInt(bound) Method  4 digit number
		 
		String userNumId = dateString+i; // take dateString reference and add int reference i and Store in userNum 
		 
		System.out.println(userNumId); 
		
		return userNumId; // return String userNum getting all localDateTime And DateTimeFormatter And Random All Data Get 
		
		
	}
	
	
	public static String generateDoctorNumber() {
		
		LocalDateTime now = LocalDateTime.now();
		
		
		DateTimeFormatter  doctorDateTime = DateTimeFormatter.ofPattern("yyMMdd");
		
		String dateDoctor = now.format(doctorDateTime);
		
		
		Random random = new Random();
		
		int i = random.nextInt(999)+100;
		
		String doctorUserNumber = dateDoctor+i;
		
		System.out.println(doctorUserNumber);
		
		return doctorUserNumber;
		
	}
	
	

}

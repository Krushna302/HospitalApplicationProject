package Com.Sojar.Hospital.Entity.Util;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailSender {
	
	
	
	
	public static void emailSend(JavaMailSender javaMailSender,String to,String firstname,String lastname,String usernumber) {
		
		try {
		
		MimeMessage mimemessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimemessage,true);

		helper.setTo(to);

		helper.setSubject("Thanks For Creating Account ");//+login.getUserRequest().getFirstname());
		
	/*	String firstName =login.getUserRequest().getFirstname();
		String lastName =login.getUserRequest().getLastname();
		String userNumber=login.getUserRequest().getUsernumber();
*/
		helper.setText("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n" + "</head>\r\n"  
				+ "    <body style=\"background-color: #FFDDDD;\">\r\n" 
				+ "    <h1 style=\"color: blue;\"> Welcome To Swasthya Hospital & MRC </h1>\r\n"
				+ "     <p> Patient Name :"
				+ "   <span style=\"color: orange;\">"+ firstname +"</span>" 
				+ "   <span style=\"color: orange;\">"+ lastname +"</span></p>\r\n"					
				+ "    <h2>Patient Number :"
				+ "   <span style=\"color:purple;\">"+usernumber+"</span></h2>\r\n"
				+ "    <p> This is a multispeciality Hospital in Ahmednagar which provides the higheststandard of clinical "
				+ "expertise. and nursing care by offering the latest technology And state-of-the-art Hospital facilities"
				+ "Hospital provides wide range of medical services like OPD Services, IPD"
				+ " Services, Emergency Services, Cahsless Services with Various Organisation"
				+ " and Insurance Companies, diagnostic, treatment, speciality clinics, "
				+ "ICU units, emergency rooms & surgery.\r\n" + 
				"</p>\r\n"
				
				+  "   <p> Best Regard,</p>\r\n "
				+ "    <p> Swasthya Hospital Team </p>\r\n"
				+ "</body>\r\n" + "</html>",true);

		// javaMailSender.send(mimemessage);
		 
		 
				}catch (Exception e) {
					
					System.out.println(e);
				}

		
	
		
		
	}

}

package Com.Sojar.Hospital.Entity.Util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import Com.Sojar.Hospital.Entity.Appointment;

public class EmailSender {

	public static void emailSend(JavaMailSender javaMailSender, String to, String firstname, String lastname,
			String usernumber) {

		try {

			MimeMessage mimemessage = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimemessage, true);

			helper.setTo(to);

			helper.setSubject("Thanks For Creating Account ");// +login.getUserRequest().getFirstname());

			/*
			 * String firstName =login.getUserRequest().getFirstname(); String lastName
			 * =login.getUserRequest().getLastname(); String
			 * userNumber=login.getUserRequest().getUsernumber();
			 */
			helper.setText("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n" + "</head>\r\n"
					+ "    <body style=\"background-color: #FFDDDD;\">\r\n"
					+ "    <h1 style=\"color: blue;\"> Welcome To Swasthya Hospital & MRC </h1>\r\n"
					+ "     <p> Patient Name :" + "   <span style=\"color: orange;\">" + firstname + "</span>"
					+ "   <span style=\"color: orange;\">" + lastname + "</span></p>\r\n" + "    <h2>Patient Number :"
					+ "   <span style=\"color:purple;\">" + usernumber + "</span></h2>\r\n"
					+ "    <p> This is a multispeciality Hospital in Ahmednagar which provides the higheststandard of clinical "
					+ "expertise. and nursing care by offering the latest technology And state-of-the-art Hospital facilities"
					+ "Hospital provides wide range of medical services like OPD Services, IPD"
					+ " Services, Emergency Services, Cahsless Services with Various Organisation"
					+ " and Insurance Companies, diagnostic, treatment, speciality clinics, "
					+ "ICU units, emergency rooms & surgery.\r\n" + "</p>\r\n"

					+ "   <p> Best Regard,</p>\r\n " + "    <p> Swasthya Hospital Team </p>\r\n" + "</body>\r\n"
					+ "</html>", true);

			 javaMailSender.send(mimemessage);

		} catch (Exception e) {

			System.out.println(e);
		}

	}
	
	// Appointment book
	public static void sendAppointmentConfirmationEmail(JavaMailSender javaMailSender, Appointment appointment) {
		try {
			MimeMessage mimemessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimemessage, true);

			helper.setTo(appointment.getEmail());
			helper.setSubject("Appointment Confirmation - Hospital Management System");

			String content = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Appointment Confirmation</title>\r\n" + "    <style>\r\n"
					+ "        body { background-color: #f4f4f4; font-family: Arial, sans-serif; color: #333; }\r\n"
					+ "        .container { max-width: 600px; margin: 0 auto; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }\r\n"
					+ "        .header { background-color: #007bff; color: #ffffff; padding: 15px; text-align: center; border-radius: 8px 8px 0 0; }\r\n"
					+ "        .header h1 { margin: 0; font-size: 24px; }\r\n"
					+ "        .content { padding: 20px; background-color: #f8f9fa; }\r\n"
					+ "        .content p { line-height: 1.6; margin-bottom: 15px; }\r\n"
					+ "        .content strong { color: #007bff; }\r\n"
					+ "        .footer { margin-top: 20px; text-align: center; font-size: 12px; color: #999999; }\r\n"
					+ "    </style>\r\n" + "</head>\r\n" + "<body>\r\n" + "    <div class=\"container\">\r\n"
					+ "        <div class=\"header\">\r\n" + "            <h1>Appointment Confirmation</h1>\r\n"
					+ "        </div>\r\n" + "        <div class=\"content\">\r\n" + "            <p>Dear "
					+ appointment.getPatientname() + ",</p>\r\n"
					+ "            <p>Your appointment has been successfully booked. Here are the details:</p>\r\n"
					+ "            <p><strong>Appointment Number:</strong> " + appointment.getAppointmentnumber()
					+ "</p>\r\n" + "            <p><strong>Patient Name:</strong> " + appointment.getPatientname()
					+ "</p>\r\n" + "            <p><strong>Date:</strong> " + appointment.getDate() + "</p>\r\n"
					+ "            <p><strong>Time:</strong> " + appointment.getTime() + "</p>\r\n"
					+ "            <p><strong>Appointed Doctor:</strong> " + appointment.getAppointedDoctor()
					+ "</p>\r\n" + "            <p><strong>Location:</strong> " + appointment.getLocation() + "</p>\r\n"
					+ "            <p><strong>Category:</strong> " + appointment.getCategory() + "</p>\r\n"
					+ "            <p><strong>Appointment Status:</strong> " + appointment.getStatus() + "</p>\r\n"
					+ "            <p><strong>Visit Type:</strong> " + appointment.getVisitType() + "</p>\r\n"
					+ "            <p>If you have any questions or need to reschedule, please contact our support team.</p>\r\n"
					+ "            <p>Thank you for choosing our services. We look forward to your visit.</p>\r\n"
					+ "            <p>Best regards,</p>\r\n"
					+ "            <p>The Hospital Management System Team</p>\r\n" + "        </div>\r\n"
					+ "        <div class=\"footer\">\r\n"
					+ "            <p>&copy; 2024 Hospital Management System. All rights reserved.</p>\r\n"
					+ "        </div>\r\n" + "    </div>\r\n" + "</body>\r\n" + "</html>";

			helper.setText(content, true);
			javaMailSender.send(mimemessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	

	// PDF File Attachment

	public static void sendAppointmentConfirmationEmailWithAttachment(JavaMailSender javaMailSender,
			Appointment appointment, String pdfFilePath) {

		try {
			MimeMessage mimemessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimemessage, true);

			helper.setTo(appointment.getEmail());
			helper.setSubject("Appointment Confirmation - Hospital Management System");

			String content = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n" + "</head>\r\n"
					+ "    <body style=\"background-color: #FFDDDD;\">\r\n"
					+ "    <h1 style=\"color: blue;\"> Welcome To Swasthya Hospital & MRC </h1>\r\n"
					+ "     <p> Patient Name :" + "   <span style=\"color: orange;\">" + appointment.getUserRequest().getFirstname() + "</span>"
					+ "   <span style=\"color: orange;\">" + appointment.getUserRequest().getLastname() + "</span></p>\r\n" + "    <h2>Patient Number :"
					+ "   <span style=\"color:purple;\">" + appointment.getUserRequest().getUsernumber() + "</span></h2>\r\n"
					+ "    <p> This is a multispeciality Hospital in Ahmednagar which provides the higheststandard of clinical "
					+ "expertise. and nursing care by offering the latest technology And state-of-the-art Hospital facilities"
					+ "Hospital provides wide range of medical services like OPD Services, IPD"
					+ " Services, Emergency Services, Cahsless Services with Various Organisation"
					+ " and Insurance Companies, diagnostic, treatment, speciality clinics, "
					+ "ICU units, emergency rooms & surgery.\r\n" + "</p>\r\n"

					+ "   <p> Best Regard,</p>\r\n " + "    <p> Swasthya Hospital Team </p>\r\n" + "</body>\r\n"
					+ "</html>";

			helper.setText(content, true);

			FileSystemResource file = new FileSystemResource(new File(pdfFilePath));

			helper.addAttachment(pdfFilePath, file);

			javaMailSender.send(mimemessage);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}

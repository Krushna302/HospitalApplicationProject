package Com.Sojar.Hospital.Entity.ServiceImplement;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.spel.ast.OpPlus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lowagie.text.pdf.PdfDictionary;

import Com.Sojar.Hospital.Entity.Appointment;
import Com.Sojar.Hospital.Entity.AssignDoctor;
import Com.Sojar.Hospital.Entity.UserRequest;
import Com.Sojar.Hospital.Entity.Constants.Constants;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Repository.AppointmentRepository;
import Com.Sojar.Hospital.Entity.Repository.DoctorRepositroy;
import Com.Sojar.Hospital.Entity.Repository.UserRepository;
import Com.Sojar.Hospital.Entity.ServiceInterface.AppointmentServiceInter;
import Com.Sojar.Hospital.Entity.ServiceInterface.PdfGenerateService;
import Com.Sojar.Hospital.Entity.Util.AppointmentRandomNum;
import Com.Sojar.Hospital.Entity.Util.EmailSender;

@Service
public class AppointmentServiceImp implements AppointmentServiceInter{
	
	
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private DoctorRepositroy doctorRepositroy;
	
	
	
	@Autowired
	private PdfGenerateService pdfGenerateService;
	
	

	
	
	@Value("${pdf.directory}")
    private String pdfDirectory;
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public ResponseDto bookAppointmentByDoctor(Appointment appointment,String usernumber) {
		
		ResponseDto responseDto = new ResponseDto();
		try {
	UserRequest user = userRepository.findByUsernumber(usernumber);
		if(user == null) {
			
			responseDto.setMsg("User Not Found.");
			
			return responseDto;
			
		}
		appointment.setUserRequest(user);
		
		AssignDoctor assignDoctor = doctorRepositroy.findByCategoryAndName(appointment.getCategory(), appointment.getAppointedDoctor());
			if(assignDoctor == null) {
	
				responseDto.setMsg("Assigned Doctor Not Found.");
				
				return responseDto;
		}
		
			
			long count =appointmentRepository.isDoctorBooked(assignDoctor.getDoctornumber(), appointment.getDate(), appointment.getTime());
			
			if(count > 0) {
				
				appointment.setStatus(Constants.PENDING);
			}else {
				
				appointment.setStatus(Constants.New);
				
			}
			appointment.setDoctornumber(assignDoctor.getDoctornumber());
			
			// Random number generated
			String appointmentId = AppointmentRandomNum.appointmentRandomNumberId();
			appointment.setAppointmentnumber(appointmentId);
			
			Appointment saveAppointment = appointmentRepository.save(appointment);
			
			
			if(saveAppointment != null) {
				
				responseDto.setMsg("Appointment Data Inserted With Status "+ appointment.getStatus());
				
			
				
				// Generated PDF

			Map<String,Object> mapPdf = new HashMap<>();
		
			mapPdf.put("appointmentnumber",appointment.getAppointmentnumber());
			mapPdf.put("patientname", appointment.getPatientname());
			mapPdf.put("bloodgroup",appointment.getBloodgroup());
			mapPdf.put("problemHistory",appointment.getProblemHistory());
			mapPdf.put("gender", appointment.getGender());
			mapPdf.put("age", appointment.getAge());
			mapPdf.put("date", appointment.getDate());
			mapPdf.put("time",appointment.getTime());
			mapPdf.put("appointedDoctor", appointment.getAppointedDoctor());
			mapPdf.put("doctornumber",appointment.getDoctornumber());
			mapPdf.put("category", appointment.getCategory());
			mapPdf.put("location", appointment.getLocation());
			mapPdf.put("status",appointment.getStatus());
			mapPdf.put("visitType", appointment.getVisitType());
			
			
			String pdfFileName = "Appointment" + appointment.getAppointmentnumber()+".pdf";
			pdfGenerateService.generatePdfFile("appointment", mapPdf, pdfFileName);
			responseDto.setMsg("PDF Generated Successfully :"+pdfFileName +"Add also send attachment  with mail to "+appointment.getEmail());
			
			String pdfFilePath =  pdfDirectory + pdfFileName;
			
			EmailSender.sendAppointmentConfirmationEmailWithAttachment(javaMailSender,appointment, pdfFilePath);
						
			}else {
				
				responseDto.setMsg("Appointment Data Not Inserted.");
			}
		
		}catch (Exception e) {
			
			responseDto.setMsg("An Error Occurred :"+e.getMessage());
			
			e.printStackTrace();
		}
		
		return responseDto;
		
		
		}
			
}

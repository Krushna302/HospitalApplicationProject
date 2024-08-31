package Com.Sojar.Hospital.Entity.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Sojar.Hospital.Entity.Appointment;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.ServiceInterface.AppointmentServiceInter;
import Com.Sojar.Hospital.Entity.ServiceInterface.PdfGenerateService;

@RestController
@RequestMapping(value ="/api/appoint")
public class AppointmentController {
	
	
	@Autowired
	private AppointmentServiceInter appointmentServiceInter;
	
	
	@Autowired 
	private PdfGenerateService pdfGenerateService;
	
	
	
	@PostMapping(value="/bookAppointment/{usernumber}")
	public ResponseEntity<ResponseDto> bookAppointmentByDoctor(@RequestBody Appointment appointment,@PathVariable String usernumber){
		
		System.out.println("Book Appointment :-"+appointment+" "+usernumber);
		
		
		 ResponseDto responseDto =  appointmentServiceInter.bookAppointmentByDoctor(appointment, usernumber);
		
		 return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		 
	}

	
		@GetMapping("/test-pdf")
		public void  generatePdfFile(HttpServletResponse response) {
			
			Appointment ap=new Appointment();
			Map<String ,Object> data = new HashMap<>();
			data.put("Appointmentnumber",ap.getAppointmentnumber());
			data.put("appointmentdate",ap.getDate());
			
			pdfGenerateService.generatePdfFile("appoint", data, "appoit1.pdf");
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package Com.Sojar.Hospital.Entity.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Sojar.Hospital.Entity.Appointment;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.ServiceInterface.AppointmentServiceInter;

@RestController
@RequestMapping(value ="/api/appiont")
public class AppointmentController {
	
	
	@Autowired
	private AppointmentServiceInter appointmentServiceInter;
	
	
	
	
	@PostMapping(value="/booksave/{usernumber}")
	public ResponseEntity<ResponseDto> bookAppointmentByDoctor(@RequestBody Appointment appointment,@PathVariable String usernumber){
		
		System.out.println("Book Appointment :-"+appointment+" "+usernumber);
		
		
		 ResponseDto responseDto =  appointmentServiceInter.bookAppointmentByDoctor(appointment, usernumber);
		
		 return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		 
	}

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

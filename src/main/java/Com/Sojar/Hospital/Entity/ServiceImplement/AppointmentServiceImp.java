package Com.Sojar.Hospital.Entity.ServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Sojar.Hospital.Entity.Appointment;
import Com.Sojar.Hospital.Entity.UserRequest;
import Com.Sojar.Hospital.Entity.Constants.Constants;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Repository.AppointmentRepository;
import Com.Sojar.Hospital.Entity.Repository.UserRepository;
import Com.Sojar.Hospital.Entity.ServiceInterface.AppointmentServiceInter;
import Com.Sojar.Hospital.Entity.Util.AppointmentRandomNum;

@Service
public class AppointmentServiceImp implements AppointmentServiceInter{
	
	
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public ResponseDto bookAppointmentByDoctor(Appointment appointment,String usernumber) {
		
		
		ResponseDto responseDto = new ResponseDto();
		
	UserRequest user = userRepository.findByUsernumber(usernumber);
		if(user != null) {
			
			// Random number generated
			String appointmentId = AppointmentRandomNum.appointmentRandomNumberId();
			appointment.setAppointmentnumber(appointmentId);
		
			appointment.setUserRequest(user);
			appointment.setStatus(Constants.New);
			appointmentRepository.save(appointment)	;
			
			responseDto.setMsg("Appointment Book");
			
			return responseDto;
		}
		
		responseDto.setMsg("Appointment Not Book");
		return responseDto;
	}

}

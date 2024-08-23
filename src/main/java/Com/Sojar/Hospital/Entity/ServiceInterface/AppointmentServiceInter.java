package Com.Sojar.Hospital.Entity.ServiceInterface;

import Com.Sojar.Hospital.Entity.Appointment;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;

public interface AppointmentServiceInter {
	
	
	ResponseDto bookAppointmentByDoctor(Appointment appointment,String usernumber);

	
	
	
}

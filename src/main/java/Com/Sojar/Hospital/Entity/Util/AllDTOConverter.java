package Com.Sojar.Hospital.Entity.Util;

import java.util.ArrayList;
import java.util.List;

import Com.Sojar.Hospital.Entity.Appointment;
import Com.Sojar.Hospital.Entity.UserRequest;
import Com.Sojar.Hospital.Entity.Dto.AppointmentDto;
import Com.Sojar.Hospital.Entity.Dto.UserRequestDto;

public class AllDTOConverter {
	
	public static List<AppointmentDto> converterAppointmentDto(List<Appointment> appointments){
		
		
		List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
		
		for(Appointment  appointment : appointments ) {
			
			appointmentDtos.add(AppointmentDto.builder()
					.appointmentnumber(appointment.getAppointmentnumber())
					.patientname(appointment.getPatientname())
					.date(appointment.getDate())
					.time(appointment.getTime())
					.gender(appointment.getGender())
					.age(appointment.getAge())
					.bloodgroup(appointment.getBloodgroup())
					.category(appointment.getCategory())
					.appointedDoctor(appointment.getAppointedDoctor())
					.referredDoctor(appointment.getReferredDoctor())
					.mobilenumber(appointment.getMobilenumber())
					.email(appointment.getEmail())
					.visitType(appointment.getVisitType())
					.problemHistory(appointment.getProblemHistory())
					.location(appointment.getLocation())
				
					.build());
			
			
		}
		
		return appointmentDtos;
		
	}
	
	
	
	public static UserRequestDto converterUserRequestDto(UserRequest userRequest) {
		
		
		return UserRequestDto.builder()
				.usernumber(userRequest.getUsernumber())
				.firstname(userRequest.getFirstname())
				.lastname(userRequest.getLastname())
				.mobnumber(userRequest.getMobnumber())
				
				
				
				.build();
	}
	

}

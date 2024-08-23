package Com.Sojar.Hospital.Entity.Dto;

import java.util.ArrayList;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserRequestDto {
	
	
	private String usernumber;
	
	private String firstname;
	
	private String lastname;
	
	private String gender;
	
	private String address;
	
	private String country;

	private int zipcode;
	
	private String mobnumber;

	private boolean status;
	
	
	private List<AppointmentDto> appointmentDto = new ArrayList<AppointmentDto>();
	
	

}

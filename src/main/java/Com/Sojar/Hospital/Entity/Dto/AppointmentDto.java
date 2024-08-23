package Com.Sojar.Hospital.Entity.Dto;

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
public class AppointmentDto {

	
    private String appointmentnumber;
	
	private String patientname;
	
	private String date;
	
	private String time;
	
	private String gender;
	
	private int age;
	
	private String bloodgroup;
	
	private String category;
	
	private String appointedDoctor;
	
	private String referredDoctor;
	
	private String mobilenumber;
	
	private String email;
	
	private String visitType;
	
	private String problemHistory;
	
	private String location;
	
	private String zipcode;
		
	
	
}

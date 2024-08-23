package Com.Sojar.Hospital.Entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

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
		
	private String doctornumber;
	
	@ManyToOne(cascade =CascadeType.ALL)
	private UserRequest userRequest;
	
	
	private String status;

	
	
	

}

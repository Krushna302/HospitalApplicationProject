package Com.Sojar.Hospital.Entity.ServiceImplement;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Sojar.Hospital.Entity.AssignDoctor;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Repository.AssignDoctorRepository;
import Com.Sojar.Hospital.Entity.ServiceInterface.DoctorServiceInter;
import Com.Sojar.Hospital.Entity.Util.UserRequestGeneraterID;

@Service
public class DoctorServiceImp implements DoctorServiceInter {
	
	
	@Autowired
	private AssignDoctorRepository assignDoctorRepository;
	
	

	@Override
	public ResponseDto insertRoleData(AssignDoctor assignDoctor) {
		
		
		ResponseDto responseDto = new ResponseDto();
		
		
		try {
			String doctorNumber = UserRequestGeneraterID.generateDoctorNumber();
			
			assignDoctor.setDoctornumber(doctorNumber);
			
		AssignDoctor assignedDoctor = assignDoctorRepository.save(assignDoctor);
		
		if(assignedDoctor !=null) {
			
			responseDto.setMsg("Assign Doctor Data Inserted.");
	
		}else {
			
			responseDto.setMsg("Assign Doctor Data Not Insert.");
			
		}
			
			
			
		} catch (Exception e) {
			
			responseDto.setMsg("Error occurred while assigning doctor data :"+e.getMessage());
		
		}
		
		
		return responseDto;
	}



	@Override
	public List<String> getAllCategory() {
		
		return	assignDoctorRepository.findAll()
								.stream()
								.map(AssignDoctor::getCategory)
								.distinct().collect(Collectors.toList());
		
		
		
	}



	@Override
	public List<AssignDoctor> getDoctorByCategory(String category) {
		
		
	List<AssignDoctor> assignDoctor =  assignDoctorRepository.findByCategory(category);
		 
		 
				
				return assignDoctor;
		
		}
	
	

}

package Com.Sojar.Hospital.Entity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Com.Sojar.Hospital.Entity.AssignDoctor;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.ServiceInterface.DoctorServiceInter;

@RestController
public class DoctorController {
	
	
	@Autowired
	private DoctorServiceInter doctorServiceInter;
	
	
	@PostMapping(value="/assignedDoctor")
	public ResponseEntity<ResponseDto> insertRoleData(@RequestBody AssignDoctor assignDoctor){
		
	ResponseDto responsedto = doctorServiceInter.insertRoleData(assignDoctor);
		
		return new ResponseEntity<ResponseDto>(responsedto,HttpStatus.OK);
		
	}
	
	
	@GetMapping(value="/category")
	public List<String> getAllCategory(){
		
	return	doctorServiceInter.getAllCategory();
		
	}
	
	
	@GetMapping(value="/doctor{category}")
	public List<AssignDoctor> getDoctorByCategory(@PathVariable String category){
		
	List<AssignDoctor> assignDoctors =	doctorServiceInter.getDoctorByCategory(category);
	
	return assignDoctors;
		
	}
	
	

}

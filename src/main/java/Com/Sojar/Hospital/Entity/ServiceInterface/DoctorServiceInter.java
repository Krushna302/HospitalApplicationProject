package Com.Sojar.Hospital.Entity.ServiceInterface;

import java.util.List;

import Com.Sojar.Hospital.Entity.AssignDoctor;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;

public interface DoctorServiceInter {
	
	
	ResponseDto insertRoleData(AssignDoctor assignDoctor);
	

	List<String> getAllCategory();
	
	List<AssignDoctor> getDoctorByCategory(String category);
	
}

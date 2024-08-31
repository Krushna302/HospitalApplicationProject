package Com.Sojar.Hospital.Entity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Com.Sojar.Hospital.Entity.AssignDoctor;



@Repository
public interface DoctorRepositroy  extends JpaRepository<AssignDoctor, Integer>{
	
	
	List<AssignDoctor> findByCategory (String category);
	
	
	AssignDoctor  findByCategoryAndName (String category ,String name);
	
	
	
	
	

}

package Com.Sojar.Hospital.Entity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Com.Sojar.Hospital.Entity.AssignDoctor;


@Repository
public interface AssignDoctorRepository extends JpaRepository<AssignDoctor, Integer> {
	
	
	AssignDoctor findByCategoryAndName(String category,String name);
	
	List<AssignDoctor> findByCategory(String category);

}

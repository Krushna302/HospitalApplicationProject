package Com.Sojar.Hospital.Entity.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Com.Sojar.Hospital.Entity.UserRequest;

@Repository
public interface  UserRepository extends JpaRepository<UserRequest, Integer> {
	
	
	UserRequest findByUsernumber(String usernumber);
	
	
	
	
	
} 

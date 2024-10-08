package Com.Sojar.Hospital.Entity.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Com.Sojar.Hospital.Entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	
	
	Login findByEmail(String email);
	
	Login findByEmailAndPassword(String email ,String password);
	
	
	@Query(nativeQuery = true,value = "select email from login;")
	List<String> findAllEmail(); 
	
	
	
	
	
}

package Com.Sojar.Hospital.Entity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Com.Sojar.Hospital.Entity.Role;

@Repository
public interface  RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByRolename(String rolename);
	
	
	
	@Query(nativeQuery = true,value = "select rolename from role;")
	List<String> findAllRole();
	

	
	
}

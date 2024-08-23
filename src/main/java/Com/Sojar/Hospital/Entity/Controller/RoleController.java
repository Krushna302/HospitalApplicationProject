package Com.Sojar.Hospital.Entity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Sojar.Hospital.Entity.Role;
import Com.Sojar.Hospital.Entity.Dto.RoleResponse;
import Com.Sojar.Hospital.Entity.ServiceInterface.RoleServiceInter;

@RestController
@RequestMapping(value="/api/admin")
public class RoleController {
	
	@Autowired
	private RoleServiceInter roleServiceInter;
	

	@PostMapping(value="/roleDataSave")
	public ResponseEntity<RoleResponse> insertRoleData(@RequestBody Role role){
	
	System.out.println("Role Data Save :-"+role);
	
	RoleResponse roleResponse = roleServiceInter.saveRoleData(role);
	
	
	return new ResponseEntity<RoleResponse>(roleResponse, HttpStatus.OK);
	
	
	
	
	}
	
}

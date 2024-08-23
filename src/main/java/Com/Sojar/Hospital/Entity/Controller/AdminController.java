package Com.Sojar.Hospital.Entity.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.Sojar.Hospital.Entity.Dto.RoleResponse;
import Com.Sojar.Hospital.Entity.ServiceInterface.AdminServiceInter;

@RestController
@RequestMapping(value="/api/admin")
public class AdminController {
	
	
	
	@Autowired
	private AdminServiceInter adminServiceInter;
	
	
	@GetMapping(value = "/assignRole")
	public ResponseEntity<RoleResponse> assignRoleToUser(@RequestParam String email,@RequestParam String rolename){
		
		System.out.println("Check Role Data For User :-"+email +"  "+rolename);
		
	RoleResponse roleresponse =	adminServiceInter.assignRoleData(email, rolename);
		
		return new ResponseEntity<RoleResponse>(roleresponse,HttpStatus.OK);
		
		
	}
	
	
	@GetMapping(value="/allEmail")
	public ResponseEntity<List<String>> getAllEmailActiveData(){
		
	List<String> emailList =	adminServiceInter.getAllEmailList();
		
		return new ResponseEntity<List<String>>(emailList, HttpStatus.OK);
		
		
	}
	
	@GetMapping(value="/allRole")
	public ResponseEntity<List<String>> getAllRoleList(){
		
		List<String> roleList = adminServiceInter.getRoleList();
		
	return new ResponseEntity<List<String>>(roleList, HttpStatus.OK);
	
	}
	
	
	

}

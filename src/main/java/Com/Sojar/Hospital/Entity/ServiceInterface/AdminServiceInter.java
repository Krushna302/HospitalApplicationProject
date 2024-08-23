package Com.Sojar.Hospital.Entity.ServiceInterface;

import java.util.List;

import Com.Sojar.Hospital.Entity.Dto.RoleResponse;

public interface AdminServiceInter {
	
	RoleResponse assignRoleData(String email ,String rolename);
	
	
	
	List<String> getAllEmailList();
	

	List<String> getRoleList();
	
}

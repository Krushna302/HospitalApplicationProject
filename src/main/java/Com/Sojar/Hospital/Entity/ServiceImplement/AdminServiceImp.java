package Com.Sojar.Hospital.Entity.ServiceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Sojar.Hospital.Entity.Login;
import Com.Sojar.Hospital.Entity.Role;
import Com.Sojar.Hospital.Entity.UserRequest;
import Com.Sojar.Hospital.Entity.Dto.RoleResponse;
import Com.Sojar.Hospital.Entity.Repository.LoginRepository;
import Com.Sojar.Hospital.Entity.Repository.RoleRepository;
import Com.Sojar.Hospital.Entity.Repository.UserRepository;
import Com.Sojar.Hospital.Entity.ServiceInterface.AdminServiceInter;

@Service
public class AdminServiceImp implements AdminServiceInter {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public RoleResponse assignRoleData(String email, String rolename) {

		Login login = loginRepository.findByEmail(email);
		if (login != null && login.getUserRequest() != null) {
			Role role = roleRepository.findByRolename(rolename);
			if (role != null) {
				UserRequest userRequest = login.getUserRequest();
				userRequest.setRole(role);
				userRepository.save(userRequest);
			}
			return RoleResponse.builder().msg("Role Assigned Successfully.").build();
		}
		return RoleResponse.builder().msg("Role Assigned Not Successfully.").build();
	}

	@Override
	public List<String> getAllEmailList() {
		

		return loginRepository.findAllEmail();
	}

	@Override
	public List<String> getRoleList() {
		
		
		return roleRepository.findAllRole();
	}														

}

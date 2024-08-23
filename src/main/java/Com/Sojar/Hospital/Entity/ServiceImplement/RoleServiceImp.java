package Com.Sojar.Hospital.Entity.ServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Com.Sojar.Hospital.Entity.Role;
import Com.Sojar.Hospital.Entity.Dto.RoleResponse;
import Com.Sojar.Hospital.Entity.Repository.RoleRepository;
import Com.Sojar.Hospital.Entity.ServiceInterface.RoleServiceInter;

@Service
public class RoleServiceImp implements RoleServiceInter {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleResponse saveRoleData(Role role) {

		RoleResponse roleResponse = new RoleResponse();

		Role role2 = roleRepository.save(role);

		if (role2 != null) {

			roleResponse.setMsg("Role Data SuccessFully Inserterd.");
		} else {

			roleResponse.setMsg("Role Data Not SuccessFully Inserterd.");

		}

		return roleResponse;

	}

}

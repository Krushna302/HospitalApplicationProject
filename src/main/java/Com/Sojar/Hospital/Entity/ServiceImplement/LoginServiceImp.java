package Com.Sojar.Hospital.Entity.ServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Sojar.Hospital.Entity.Login;
import Com.Sojar.Hospital.Entity.UserRequest;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Dto.UserResponseDto;
import Com.Sojar.Hospital.Entity.Repository.LoginRepository;
import Com.Sojar.Hospital.Entity.ServiceInterface.LoginServiceInter;

@Service
public class LoginServiceImp implements LoginServiceInter {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserResponseDto getLoginData(String email, String password) {

		UserResponseDto userResponseDto = new UserResponseDto();

		Login login = loginRepository.findByEmailAndPassword(email, password);

		if (login != null && login.getUserRequest() != null) {

			UserRequest userRequest = login.getUserRequest();

			if (userRequest.getRole() != null) {

				if (userRequest.isStatus()) {

					userResponseDto.setUsernumber(userRequest.getUsernumber());

					userResponseDto.setFirstname(userRequest.getFirstname());

					userResponseDto.setLastname(userRequest.getLastname());

					userResponseDto.setEmail(login.getEmail());

					userResponseDto.setMobnumber(userRequest.getMobnumber());
					userResponseDto.setRolename(userRequest.getRole().getRolename());

					return userResponseDto;

				} else {

					userResponseDto.setErrormsg("Access Denied.");

					return userResponseDto;
				}

			} else {

				userResponseDto.setErrormsg("Access Not Provide.Please Contact Your Administrator.");

				return userResponseDto;
			}

		} else {

			userResponseDto.setErrormsg("User Can Not Find.");

			return userResponseDto;

		}

	}

	@Override
	public ResponseDto forgotPassword(String email, String password) {

		ResponseDto responseDto = new ResponseDto();

		Login login = loginRepository.findByEmail(email);

		login.setPassword(password);
		Login login2 = loginRepository.save(login);

		if (login2 != null) {

			responseDto.setMsg("Password Updata Successfully");
		} 
		else {
			responseDto.setMsg("Password Not Updata Successfully");
			
		}

		return responseDto;

		
	}

}

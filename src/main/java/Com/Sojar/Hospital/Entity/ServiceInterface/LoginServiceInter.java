package Com.Sojar.Hospital.Entity.ServiceInterface;

import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Dto.UserResponseDto;

public interface LoginServiceInter {

	
	
	
	
	
	UserResponseDto getLoginData(String email,String password);
	
	ResponseDto forgotPassword(String email ,String password);
	
	
	
	
}

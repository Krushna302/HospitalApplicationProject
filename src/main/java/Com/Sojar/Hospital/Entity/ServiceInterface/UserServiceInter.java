package Com.Sojar.Hospital.Entity.ServiceInterface;





import Com.Sojar.Hospital.Entity.Login;
import Com.Sojar.Hospital.Entity.UserRequest;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Dto.UserRequestDto;


public interface UserServiceInter {
	
	
	ResponseDto addRegisterUserRequest(Login login);
	
	UserRequest getDataByUserNumber (String usernumber);
	
	UserRequest updateUserRequestData(UserRequest userRequest);
	
	UserRequest deleteUserRequestByEmail(String email);  // first way delete
	
	 ResponseDto deleteUserRequestDataById(String usernumber);   // second way delete
	 
	 ResponseDto updatePecificUserRequestData(String usernumber ,UserRequest userRequest);

	UserRequest  getUserRequestData(String usernumber);
	 
	UserRequestDto getUserAppointmentDetails(String usernumber);
	 
	 
	 
	 
}

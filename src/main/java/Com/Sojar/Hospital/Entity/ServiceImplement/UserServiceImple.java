package Com.Sojar.Hospital.Entity.ServiceImplement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import Com.Sojar.Hospital.Entity.Appointment;
import Com.Sojar.Hospital.Entity.Login;
import Com.Sojar.Hospital.Entity.Role;
import Com.Sojar.Hospital.Entity.UserRequest;
import Com.Sojar.Hospital.Entity.Dto.AppointmentDto;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Dto.UserRequestDto;
import Com.Sojar.Hospital.Entity.Exception.ExceptionHandleMsgResponse;
import Com.Sojar.Hospital.Entity.Repository.AppointmentRepository;
import Com.Sojar.Hospital.Entity.Repository.LoginRepository;
import Com.Sojar.Hospital.Entity.Repository.RoleRepository;
import Com.Sojar.Hospital.Entity.Repository.UserRepository;
import Com.Sojar.Hospital.Entity.ServiceInterface.UserServiceInter;
import Com.Sojar.Hospital.Entity.Util.AllDTOConverter;
import Com.Sojar.Hospital.Entity.Util.EmailSender;
import Com.Sojar.Hospital.Entity.Util.UserRequestGeneraterID;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImple implements UserServiceInter {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public ResponseDto addRegisterUserRequest(Login login) {

		ResponseDto responseDto = new ResponseDto();

		Login login2 = null;

		if (login.getEmail() == null) {

			System.out.println("User Email Null Calling");

			responseDto.setMsg("User Can not be null");

			return responseDto;

		}

		Login login1 = loginRepository.findByEmail(login.getEmail());

		System.out.println("User 3 Calling :- " + login1);

		if (login1 != null) {

			System.out.println("User Email Null Calling.");

			responseDto.setMsg("User Already Exist.");

			return responseDto;

		}

		System.out.println("Calling 3");

		System.out.println("UserNumId Calling");

		//Random Usernumber
		
		String userNumId = UserRequestGeneraterID.generaterUseNumId();
		login.getUserRequest().setUsernumber(userNumId);
		
		login.getUserRequest().setStatus(true);
		Role role = roleRepository.findByRolename("Patient"); // by default patient set
		login.getUserRequest().setRole(role); // patient set role
		login2 = loginRepository.save(login);

		if (login2 != null && login2.getId() > 0) {
			responseDto.setMsg("User Successfully Resgistered.");
			
			
			// Email Send Code

			EmailSender.emailSend(javaMailSender, login.getEmail(), login.getUserRequest().getFirstname(),
					login.getUserRequest().getLastname(), login.getUserRequest().getUsernumber());

			return responseDto;

		} else {
			responseDto.setMsg("User Not Successfully Registered.");
			return responseDto;

		}

	}

	@Override
	public UserRequest getDataByUserNumber(String usernumber) {

		UserRequest userRequest = null;

		try {

			userRequest = userRepository.findByUsernumber(usernumber);
			System.out.println(userRequest.getUsernumber());

		} catch (Exception e) {

			System.out.println(e);

			throw new ExceptionHandleMsgResponse("Please Try Again..Invalid UserNumber..!!");

		}

		return userRequest;
	}

	// second way update
	@Override
	public UserRequest updateUserRequestData(UserRequest userRequest) {

		UserRequest userUpdate = userRepository.save(userRequest);

		return userUpdate;
	}

	// first way delete
	@Override
	public UserRequest deleteUserRequestByEmail(String email) {

		UserRequest request = new UserRequest();

		Login login = null;

		try {
			login = loginRepository.findByEmail(email);
			loginRepository.delete(login);

		} catch (Exception e) {

			System.out.println(e);

			throw new ExceptionHandleMsgResponse("Please Check Email Id..");

		}
		return request;

	}

	// Second way delete
	@Override
	public ResponseDto deleteUserRequestDataById(String usernumber) {

		ResponseDto responseDto = new ResponseDto();

		UserRequest request = userRepository.findByUsernumber(usernumber);

		if (request == null) {
			responseDto.setMsg("Please Check UserNumber Is Invalid..!!");
			return responseDto;

		} else {

			userRepository.delete(request);
			responseDto.setMsg("Delete Successfully UserNumber Details Data..!!");

			return responseDto;
		}

	}

	// second way update
	@Override
	public ResponseDto updatePecificUserRequestData(String usernumber, UserRequest userRequest) {

		ResponseDto responseDto = new ResponseDto();

		UserRequest setuserdata = userRepository.findByUsernumber(usernumber);

		if (setuserdata == null) {

			responseDto.setMsg("UserNumber Not Found Data");
			return responseDto;

		}
		setuserdata.setFirstname(userRequest.getFirstname());
		setuserdata.setLastname(userRequest.getLastname());
		setuserdata.setGender(userRequest.getGender());
		setuserdata.setMobnumber(userRequest.getMobnumber());
		setuserdata.setAddress(userRequest.getAddress());
		setuserdata.setZipcode(userRequest.getZipcode());
		setuserdata.setCountry(userRequest.getCountry());

		userRepository.save(setuserdata);

		responseDto.setMsg("UserNumber Data Successfully Update");

		return responseDto;
	}

	@Override
	public UserRequest getUserRequestData(String usernumber) {
		
	UserRequest user = userRepository.findByUsernumber(usernumber);
	
	//Log.debug("User Request Data Fetching :-"+user);
		
		return user;
	}

	@Override
	public UserRequestDto getUserAppointmentDetails(String usernumber) {
		
		UserRequestDto userRequestDto = null;
		
		UserRequest user = userRepository.findByUsernumber(usernumber);

		
		if(user!=null) {
			
			userRequestDto = AllDTOConverter.converterUserRequestDto(user);
			
		}
		
		
		List<Appointment> appointment =	appointmentRepository.findByUserRequestUsernumber(usernumber);//	    // Fetch the list of appointments based on the user's number

	

	List<AppointmentDto> appointmentDtos = AllDTOConverter.converterAppointmentDto(appointment);
	
	userRequestDto.setAppointmentDto(appointmentDtos);
	
    //log.debug = Debug output to check the retrieved list of appointments
	//System.out.println("Appointment List :-"+appointment);
    // Convert the list of appointments to a UserRequestDto
	//UserRequestDto userRequestDto = new UserRequestDto();
	// set appointment is use to userRequestDto in the list after set here
	//userRequestDto.setAppointment(appointment);
	
		return userRequestDto;
	}
}

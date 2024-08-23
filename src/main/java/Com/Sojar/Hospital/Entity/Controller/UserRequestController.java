package Com.Sojar.Hospital.Entity.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Sojar.Hospital.Entity.Login;
import Com.Sojar.Hospital.Entity.UserRequest;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Dto.UserRequestDto;
import Com.Sojar.Hospital.Entity.ServiceInterface.UserServiceInter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/user")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
public class UserRequestController {

	@Autowired
	private UserServiceInter userServiceInter;

	@PostMapping(value = "/save", consumes = "application/json")
	public ResponseEntity<ResponseDto> requestUserRequest(@RequestBody Login login) {

		System.out.println("Check User Request Data :- " + login);

		ResponseDto responseDto = userServiceInter.addRegisterUserRequest(login); // Return ResponseDto

		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

	}

	@GetMapping(value = "/getData/{usernumber}")
	public ResponseEntity<UserRequest> getDataByUserNumber(@PathVariable String usernumber) {
		System.out.println("Get UserNumber Data :- " + usernumber);

		UserRequest userRequest = userServiceInter.getDataByUserNumber(usernumber);

		return new ResponseEntity<UserRequest>(userRequest, HttpStatus.OK);

	}

	// first way update
	@PutMapping(value = "/updateUserRequestData")
	public ResponseEntity<String> updateUserRequestData(@RequestBody UserRequest userRequest) {

		UserRequest userUpdata = userServiceInter.updateUserRequestData(userRequest);

		if (userUpdata != null) {

			return new ResponseEntity<String>("Update UserRequest Account Details  Successfully", HttpStatus.OK);
		} else {

			return new ResponseEntity<String>("Account Details Not Update Successfully", HttpStatus.NOT_FOUND);
		}

	}

	// first way delete data
	@DeleteMapping(value = "/deleteUserRequestEmail/{email}")
	public ResponseEntity<UserRequest> deleteUserRequestByEmail(@PathVariable String email) {

		UserRequest user = userServiceInter.deleteUserRequestByEmail(email);

		if (user == null) {
			return new ResponseEntity<UserRequest>(user, HttpStatus.OK);

		} else {

			return new ResponseEntity<UserRequest>(user, HttpStatus.NOT_FOUND);

		}

	}

	// second way delete
	@DeleteMapping(value = "/deleteUserReqestId/{usernumber}")
	public ResponseEntity<ResponseDto> deleteUserRequestDataById(@PathVariable String usernumber) {
		System.out.println("Check UserRequest Id :-" + usernumber);

		ResponseDto responseDto = userServiceInter.deleteUserRequestDataById(usernumber);

		if (responseDto == null) {

			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

		} else {

			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.NOT_FOUND);
		}

	}

	// second way update
	@PutMapping(value = "/updateUserData/{usernumber}")
	public ResponseEntity<ResponseDto> updatePecificUserRequestData(@PathVariable String usernumber,
			@RequestBody UserRequest userRequest) {

		ResponseDto responseDto = userServiceInter.updatePecificUserRequestData(usernumber, userRequest);

		if (responseDto == null) {

			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		} else {

			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.NOT_FOUND);

		}

	}

	
	
	@GetMapping(value="/findUser/{usernumber}")
	public ResponseEntity<UserRequest> getUserRequestData(@PathVariable String usernumber){
		
		log.info("User Request Patient Data Fetching :-"+usernumber);
		
		
	UserRequest user =	userServiceInter.getUserRequestData(usernumber);
		
	return new ResponseEntity<UserRequest>(user, HttpStatus.OK);
	
		
		
	}
	
	
	@GetMapping(value="/userAllAppointment/{usernumber}")
	public ResponseEntity<UserRequestDto> getUserAppointmentDetails(@PathVariable String usernumber){
		
		log.info("Checkng User Number :"+usernumber);
		
	UserRequestDto userRequestDto =	userServiceInter.getUserAppointmentDetails(usernumber);
		
	if(userRequestDto !=null) {
		
		return new ResponseEntity<UserRequestDto>(userRequestDto, HttpStatus.OK);	
	}
	else {
		
		return new ResponseEntity<UserRequestDto>(userRequestDto, HttpStatus.NOT_FOUND);
		
	}
	
	
		
	}
	
	
	
	
	
	
	
}

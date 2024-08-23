package Com.Sojar.Hospital.Entity.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.Sojar.Hospital.Entity.Login;
import Com.Sojar.Hospital.Entity.Dto.ResponseDto;
import Com.Sojar.Hospital.Entity.Dto.UserResponseDto;
import Com.Sojar.Hospital.Entity.Filter.jwtUtility;
import Com.Sojar.Hospital.Entity.JwtService.UserService;
import Com.Sojar.Hospital.Entity.ServiceInterface.LoginServiceInter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {
	
	
	
	@Autowired
	private LoginServiceInter loginServiceInter;
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private jwtUtility jwtUtility;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value="/login")
	public ResponseEntity<UserResponseDto> getLoginData(@RequestBody Login login) throws Exception{
	
		//System.out.println("Login Credentials Check : " + login);
		log.info("Checking Login Data INFO : " + login);
		log.warn("Checking Login Data WARN : " + login);
		log.debug("Checking Login Data DEBUG : " + login);
		log.trace("Checking Login Data TRACE: " + login);

		
		
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getEmail(),
                            login.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(login.getEmail());

        final String token =
                jwtUtility.generateToken(userDetails);
		
	
		
	UserResponseDto userResponseDto = loginServiceInter.getLoginData(login.getEmail(), login.getPassword());
		
	userResponseDto.setToken(token);
	
		return new ResponseEntity<UserResponseDto>(userResponseDto, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value="/forgotPassword")
	public ResponseEntity<ResponseDto> forgotPassword(@RequestParam String email ,@RequestParam String password){
	
		System.out.println("Check Updated Password :-"+email+" "+password);
		
		ResponseDto responseDto = loginServiceInter.forgotPassword(email, password);
		
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		
		
		
	}
	
	

}

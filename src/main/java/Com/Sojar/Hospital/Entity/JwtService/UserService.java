package Com.Sojar.Hospital.Entity.JwtService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Com.Sojar.Hospital.Entity.Login;
import Com.Sojar.Hospital.Entity.Repository.LoginRepository;

@Service
public class UserService implements UserDetailsService {

	
	
	
	@Autowired
	private LoginRepository loginRepository;
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Login login =loginRepository.findByEmail(email);
		return new User(login.getEmail(), login.getPassword(), new ArrayList<>());
	}

}
	


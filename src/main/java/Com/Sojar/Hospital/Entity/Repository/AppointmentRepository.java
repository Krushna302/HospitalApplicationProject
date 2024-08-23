package Com.Sojar.Hospital.Entity.Repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import Com.Sojar.Hospital.Entity.Appointment;



@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


	
	List<Appointment> findByUserRequestUsernumber(String usernumber);
  
	
}

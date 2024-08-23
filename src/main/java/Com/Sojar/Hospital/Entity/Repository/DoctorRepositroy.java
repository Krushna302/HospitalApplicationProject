package Com.Sojar.Hospital.Entity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Sojar.Hospital.Entity.AssignDoctor;

public interface DoctorRepositroy  extends JpaRepository<AssignDoctor, Integer>{

}

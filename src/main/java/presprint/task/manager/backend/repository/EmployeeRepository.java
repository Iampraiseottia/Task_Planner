package radius.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import radius.drone.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
 

}

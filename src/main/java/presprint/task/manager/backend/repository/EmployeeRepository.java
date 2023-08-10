package presprint.task.manager.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import presprint.task.manager.backend.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    Employee findByName(String name);
}

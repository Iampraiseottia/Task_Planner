package presprint.task.manager.backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import presprint.task.manager.backend.entity.Employee;
import presprint.task.manager.backend.entity.Status;
import presprint.task.manager.backend.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	 List<Task> findByEmployeeAndStatusAndRegistrationDateBetween(Employee employee, Status status,Date startDate, Date endDate );
	 List<Task> findByEmployeeAndRegistrationDateBetween(Employee employee,Date startDate, Date endDate);
	 List<Task> findByStatusAndRegistrationDateBetween( Status status,Date startDate, Date endDate);
	 List<Task> findByRegistrationDateBetween(Date startDate, Date endDate);


}

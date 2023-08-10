package presprint.task.manager.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import presprint.task.manager.backend.entity.Employee;
import presprint.task.manager.backend.entity.Status;
import presprint.task.manager.backend.entity.Task;

public interface TaskService {


    public void save(Task task);
    Optional<Task> findById(int id);

    List<Task> findAll();
    List<Task> findByEmployeeAndStatusAndRegistrationDateBetween(Employee employee, Status status,Date startDate, Date endDate );
    List<Task> findByEmployeeAndRegistrationDateBetween(Employee employee,Date startDate, Date endDate);
    List<Task> findByStatusAndRegistrationDateBetween( Status status,Date startDate, Date endDate);
    List<Task> findByRegistrationDateBetween(Date startDate, Date endDate);


}

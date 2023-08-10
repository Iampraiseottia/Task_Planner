package presprint.task.manager.backend.service;

import org.springframework.stereotype.Service;

import presprint.task.manager.backend.entity.Employee;
import presprint.task.manager.backend.entity.Status;
import presprint.task.manager.backend.entity.Task;
import presprint.task.manager.backend.repository.TaskRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Task task) {
    	taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

	@Override
	public List<Task> findByEmployeeAndStatusAndRegistrationDateBetween(Employee employee, Status status,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return taskRepository.findByEmployeeAndStatusAndRegistrationDateBetween(employee,status,startDate,  endDate);
	}

	@Override
	public List<Task> findByEmployeeAndRegistrationDateBetween(Employee employee, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return taskRepository.findByEmployeeAndRegistrationDateBetween(employee,startDate,  endDate);
	}

	@Override
	public List<Task> findByStatusAndRegistrationDateBetween(Status status, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return taskRepository.findByStatusAndRegistrationDateBetween(status,startDate,  endDate);
	}

	@Override
	public List<Task> findByRegistrationDateBetween(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return taskRepository.findByRegistrationDateBetween(startDate,  endDate);
	}
}

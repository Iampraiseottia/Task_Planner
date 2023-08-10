package presprint.task.manager.backend.service;

import presprint.task.manager.backend.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Employee findByName(String name);
    public Optional<Employee> findById(int id);
    public List<Employee> findAll();

}

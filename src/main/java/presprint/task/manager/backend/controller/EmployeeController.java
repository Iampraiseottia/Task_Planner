package presprint.task.manager.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import presprint.task.manager.backend.entity.Employee;
import presprint.task.manager.backend.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @RequestMapping(value="/getAllEmployees", method = RequestMethod.GET)
    public List<String> getAllStatus() {
        List<Employee> allEmployees = employeeService.findAll();
        List<String> employees = new ArrayList<String>();
        for (Employee status: allEmployees) {
            employees.add(status.getName());
        }
        return employees;
    }
}

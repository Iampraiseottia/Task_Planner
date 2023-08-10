package presprint.task.manager.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import presprint.task.manager.backend.entity.Employee;
import presprint.task.manager.backend.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author PRESPRINT PLC August 2023
 * This Code is mainly for the training of trainee
 * to communicate with a  basic backend service through 
 * ajax call
 *
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @RequestMapping(value="/getAllEmployees", method = RequestMethod.GET)
    public List<String> getAllEmployees() {
        List<Employee> allEmployees = employeeService.findAll();
        List<String> employees = new ArrayList<String>();
        for (Employee status: allEmployees) {
            employees.add(status.getName());
        }
        return employees;
    }
}

package org.anyrem.spring_boot.restcrud.hibarnate_demo.rest;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.dao.EmployeeDao;
import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;
import org.anyrem.spring_boot.restcrud.hibarnate_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> findAll() {

        return employeeService.findAll();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.update(employee);
        return employee;
    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {

        try {
            employeeService.deleteById(employeeId);
            return "Employee " + employeeId + " deleted";

        } catch (Exception e) {
            return "Employee" + employeeId + "NOT deleted: " + e.getMessage();
        }
    }

}
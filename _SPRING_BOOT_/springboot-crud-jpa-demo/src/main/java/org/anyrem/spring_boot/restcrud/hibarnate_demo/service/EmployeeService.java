package org.anyrem.spring_boot.restcrud.hibarnate_demo.service;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);

    void update(Employee employee);

}

package org.anyrem.springboot.thymeleafdemo.service;


import org.anyrem.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllByOrderByLastNameAsc();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);

    void update(Employee employee);

}

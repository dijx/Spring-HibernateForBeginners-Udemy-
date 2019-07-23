package org.anyrem.spring_boot.restcrud.hibarnate_demo.dao;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;
import org.anyrem.spring_boot.restcrud.hibarnate_demo.rest.EmployeeRestController;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteObject(Employee employee);

    void deleteById(int id);

    void update(Employee employee);
}

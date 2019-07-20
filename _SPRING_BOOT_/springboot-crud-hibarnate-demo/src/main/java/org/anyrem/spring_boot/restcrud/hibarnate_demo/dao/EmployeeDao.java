package org.anyrem.spring_boot.restcrud.hibarnate_demo.dao;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

}

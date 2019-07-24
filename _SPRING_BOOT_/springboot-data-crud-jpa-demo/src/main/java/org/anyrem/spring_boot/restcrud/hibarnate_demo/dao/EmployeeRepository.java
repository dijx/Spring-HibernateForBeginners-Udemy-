package org.anyrem.spring_boot.restcrud.hibarnate_demo.dao;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

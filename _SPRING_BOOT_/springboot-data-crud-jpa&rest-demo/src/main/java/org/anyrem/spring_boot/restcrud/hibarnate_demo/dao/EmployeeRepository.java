package org.anyrem.spring_boot.restcrud.hibarnate_demo.dao;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//default path is lowercase entity + "s" - Employee = employees. To override:
//@RepositoryRestResource(path = "staff")
@RepositoryRestResource(path = "people")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

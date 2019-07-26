package org.anyrem.springboot.thymeleafdemo.service;

import org.anyrem.springboot.thymeleafdemo.dao.EmployeeRepository;
import org.anyrem.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional - JPARepository provides transaction support out of the box.
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
//
//    public EmployeeServiceImpl(@Qualifier("employeeRepositoryJpaImpl")EmployeeDao employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("ID not found: " + id);
        }
    }

    @Override
    public void save(Employee employee) {

        employee.setId(0);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {

//        employeeRepository.deleteObject(employeeRepository.findById(id));
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {

        employeeRepository.save(employee);
    }
}

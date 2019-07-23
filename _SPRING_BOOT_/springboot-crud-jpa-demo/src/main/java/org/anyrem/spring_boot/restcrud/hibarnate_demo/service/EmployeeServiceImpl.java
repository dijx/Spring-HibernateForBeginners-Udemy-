package org.anyrem.spring_boot.restcrud.hibarnate_demo.service;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.dao.EmployeeDao;
import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    @Qualifier("employeeDaoJpaImpl")
    private EmployeeDao employeeDao;
//
//    public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl")EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    @Override
    public List<Employee> findAll() {

        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {

        return employeeDao.findById(id);
    }

    @Override
    public void save(Employee employee) {

        employee.setId(0);
        employeeDao.save(employee);
    }

    @Override
    public void deleteById(int id) {

//        employeeDao.deleteObject(employeeDao.findById(id));
        employeeDao.deleteById(id);
    }

    @Override
    public void update(Employee employee) {

        employeeDao.update(employee);
    }
}

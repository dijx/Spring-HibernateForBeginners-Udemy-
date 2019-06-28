package org.anyrem.springdemo.hibernate.practice;

import org.anyrem.springdemo.hibernate.practice.dao.EmployeeDao;
import org.anyrem.springdemo.hibernate.practice.entity.Employee;

import java.util.List;

public class App {

    private static EmployeeDao employeeDao = new EmployeeDao();

    public static void main(String[] args) {

//        employeeDao.save(new Employee("John", "Doe", "Vitex"));

//        Employee employee = employeeDao.findById(1);
//        System.out.println(employee);

        //List by company
        List<Employee> vitexEmployees = employeeDao.findByCompany("Vitex");

        for (Employee vitexEmployee : vitexEmployees) {
            System.out.println(vitexEmployee);
        }

        //Delete by id:
        //employeeDao.deleteById(1);

        //Update company by ID
        employeeDao.updateCompany(2, "Mirex");


    }


}

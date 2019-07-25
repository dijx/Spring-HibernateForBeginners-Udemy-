package org.anyrem.springboot.thymeleafdemo.util;

import org.anyrem.springboot.thymeleafdemo.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeesFactory {

    private static List<Employee> instance = generate();

    private static List<Employee> generate() {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Anna", "Abecka", "abecka@abecka.org"));
        employees.add(new Employee("Barbara", "Bebecka", "bebecka@bebecka.org"));
        employees.add(new Employee("Celina", "Cabecka", "cabecka@cabecka.org"));

        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).setId(i);
        }

        return employees;
    }

    public static List<Employee> getInstance() {
        return instance;
    }
}

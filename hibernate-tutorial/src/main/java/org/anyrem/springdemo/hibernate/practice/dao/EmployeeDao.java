package org.anyrem.springdemo.hibernate.practice.dao;

import org.anyrem.springdemo.hibernate.practice.AppSessionFactory;
import org.anyrem.springdemo.hibernate.practice.entity.Employee;
import org.hibernate.Session;

import java.util.List;


public class EmployeeDao {


    public void save(Employee employee) {

        Session session = AppSessionFactory.getSession();

        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println("Saved employee:");
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public Employee findById(int id) {

        Session session = AppSessionFactory.getSession();

        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();

        System.out.println("Employee #" + id);
        System.out.println(employee);

        session.close();

        return employee;

    }


    public List<Employee> findByCompany(String company) {

        Session session = AppSessionFactory.getSession();

        session.beginTransaction();

        List<Employee> employees = session.createQuery("from Employee e where e.company = :company")
                .setParameter("company", company)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return employees;
    }

    public void deleteById(int id) {

        Session session = AppSessionFactory.getSession();
        session.beginTransaction();

        session.delete(session.get(Employee.class, id));

        session.getTransaction().commit();
        session.close();

        System.out.println("Deleted id: " + id);
    }

    public void updateCompany(int id, String company) {

        Session session = AppSessionFactory.getSession();
        session.beginTransaction();

        session.createQuery("update Employee e set e.company = :company where e.id = :id")
                .setParameter("id", id)
                .setParameter("company", company)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}

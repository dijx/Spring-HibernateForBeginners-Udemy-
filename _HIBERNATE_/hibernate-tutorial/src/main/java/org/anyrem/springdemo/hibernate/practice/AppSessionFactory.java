package org.anyrem.springdemo.hibernate.practice;

import org.anyrem.springdemo.hibernate.practice.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppSessionFactory {

    public static Session getSession() {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        return session;
    }

    private AppSessionFactory() {
    }
}

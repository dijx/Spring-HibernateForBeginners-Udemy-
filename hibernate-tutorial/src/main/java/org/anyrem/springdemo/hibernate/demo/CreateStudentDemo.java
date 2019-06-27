package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            System.out.println("creating student object");

            Student student = new Student("John", "Doe", "jdoe@domain.com");

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

            System.out.println("done");

        } finally {
            factory.close();
        }
    }
}

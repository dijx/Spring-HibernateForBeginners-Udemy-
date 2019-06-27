package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            System.out.println("fetching student from DB");

            Student readStudent = new Student();

            session.beginTransaction();

            readStudent = session.get(Student.class, 1);

            session.getTransaction().commit();

            System.out.println("done");
            System.out.println(readStudent);

        } finally {
            factory.close();
        }
    }
}

package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            System.out.println("querying student(s) from DB");

            List<Student> readStudents = new ArrayList<>();

            session.beginTransaction();

            readStudents = session.createQuery("from Student").getResultList();

            List<Student> selectedStudents = session.createQuery("from Student s where s.email like 'S%'").getResultList();

            session.getTransaction().commit();

            System.out.println("done");

            displayStudents(readStudents);

            System.out.println("========selected");
            displayStudents(selectedStudents);


        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> readStudents) {
        for (Student readStudent : readStudents) {

            System.out.println(readStudent);

        }
    }
}

package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            System.out.println("updating student(s) from DB");

            session.beginTransaction();

            Student student = session.get(Student.class, 1);

            if (student.getFirstName().equals("John")) {
                student.setFirstName("Jack");
            } else {
                student.setFirstName("John");
            }

            Student studentUpdated = session.get(Student.class, 1);

            System.out.println("Updating emails for all");

            session.createQuery("update Student set email='foo@bar.org'")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println(studentUpdated);

            System.out.println("done");

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

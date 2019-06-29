package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Course;
import org.anyrem.springdemo.hibernate.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class CreateCourseAndStudentsDemo {


    public static void main(String[] args) {

        Session session = AppSessionFactory.getSession();

        try {
            session.beginTransaction();

            Course course1 = new Course("Pacman - a way to mastery");

            session.save(course1);

            System.out.println(">>> saved ourse: \n" + course1);

            Student student1 = new Student("John", "Doe", "jdoe@domain.com");
            Student student2 = new Student("Paula", "Public", "ppublic@domain.com");

            course1.addStudent(student1);
            course1.addStudent(student2);

            for (Student student : course1.getStudents()) {
                System.out.println(">>> saving " + student.getEmail());
                session.save(student);
            }


            session.getTransaction().commit();

            System.out.println(">>> Done");

        } catch (HibernateException e) {

            e.printStackTrace();

        } finally {

            session.close();
        }
    }

}

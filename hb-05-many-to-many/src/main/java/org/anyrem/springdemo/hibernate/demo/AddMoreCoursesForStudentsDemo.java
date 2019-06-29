package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Course;
import org.anyrem.springdemo.hibernate.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class AddMoreCoursesForStudentsDemo {


    public static void main(String[] args) {

        Session session = AppSessionFactory.getSession();

        try {
            session.beginTransaction();

            int theId = 2;
            Student student1 = session.get(Student.class, theId);
            System.out.println(">>> Student:\n" + student1);

            Course course1 = new Course("Rubic's cube - how to speed cube");
            Course course2 = new Course("Commodore 64 - game developement");

            System.out.println(">>> Saving courses");

            session.save(course1);
            session.save(course2);

            student1.addCourse(course1);
            student1.addCourse(course2);

            session.save(student1);

            session.getTransaction().commit();

            System.out.println(">>> Done");

        } catch (HibernateException e) {

            e.printStackTrace();

        } finally {

            session.close();
        }
    }

}

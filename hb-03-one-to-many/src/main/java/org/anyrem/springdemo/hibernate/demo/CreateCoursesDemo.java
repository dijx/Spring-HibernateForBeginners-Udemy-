package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Course;
import org.anyrem.springdemo.hibernate.demo.entity.Instructor;
import org.hibernate.Session;


public class CreateCoursesDemo {

    public static void main(String[] args) {


        Session session = AppSessionFactory.getSession();
        session.beginTransaction();

        int theId = 1;

        Instructor instructor = session.get(Instructor.class, theId);

        Course course1 = new Course("Guitar - the ultimate guide");
        Course course2 = new Course("Building dirty bomb - practical guide");

        instructor.addCourse(course1);
        instructor.addCourse(course2);

        session.save(course1);
        session.save(course2);

        session.update(instructor);

        session.getTransaction().commit();
        session.close();

    }
}

package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Course;
import org.anyrem.springdemo.hibernate.demo.entity.Instructor;
import org.hibernate.Session;


public class GetInstructorDetailDemo {

    public static void main(String[] args) {


        Session session = AppSessionFactory.getSession();

        session.beginTransaction();

        int theID = 1;

        Instructor instructor = session.get(Instructor.class, theID);

        System.out.println("Instructor info:\n" + instructor);
        System.out.println("Instructor's courses details");

        for (Course c : instructor.getCourses()) {
            System.out.println(c);
        }

        session.getTransaction().commit();

        session.close();

        System.out.println("done");

    }
}

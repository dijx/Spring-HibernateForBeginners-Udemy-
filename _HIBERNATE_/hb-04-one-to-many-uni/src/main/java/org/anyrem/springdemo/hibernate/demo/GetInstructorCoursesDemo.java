package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;


public class GetInstructorCoursesDemo {

    public static void main(String[] args) {


        Session session = AppSessionFactory.getSession();

        session.beginTransaction();

        int theID = 1;

        InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);

        System.out.println("Instructor details:\n" + instructorDetail);
        System.out.println("Associated instructor:\n" + instructorDetail.getInstructor());


        session.getTransaction().commit();

        session.close();

        System.out.println("done");

    }
}

package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Instructor;
import org.anyrem.springdemo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;


public class CreateInstructorDemo {

    public static void main(String[] args) {


        Session session = AppSessionFactory.getSession();
/*

        Instructor instructor1 = new Instructor("Jan", "Nowak", "jnowak@domain.com");

        InstructorDetail instructorDetail1 = new InstructorDetail("http://youtu.be/hahaha", "drinking");

        instructor1.setInstructorDetail(instructorDetail1);


            session.beginTransaction();

            session.save(instructor1);

            session.getTransaction().commit();

            System.out.println("done");

*/

        Instructor instructor1 = new Instructor("Jan", "Kowalski", "jkowalski@domain.com");

        InstructorDetail instructorDetail1 = new InstructorDetail("http://youtu.be/hihihi", "puffing the magic dragon");

        instructor1.setInstructorDetail(instructorDetail1);


        session.beginTransaction();

        session.save(instructor1);

        session.getTransaction().commit();

        System.out.println("done");

    }
}

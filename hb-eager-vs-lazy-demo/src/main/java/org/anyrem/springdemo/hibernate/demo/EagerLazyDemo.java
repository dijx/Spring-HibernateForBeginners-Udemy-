package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class EagerLazyDemo {

    public static void main(String[] args) {

        Session session = AppSessionFactory.getSession();

        try {

            session.beginTransaction();

            int theID = 1;

            Instructor instructor = session.get(Instructor.class, theID);

            System.out.println(">>> Instructor details:\n" + instructor);


            System.out.println(">>> Associated courses:\n" + instructor.getCourses());


            session.getTransaction().commit();

            session.close();

            //testing LAZY fetching after connection closed
            System.out.println(">>> Associated courses:\n" + instructor.getCourses());


            System.out.println(">>> done");

        } catch (HibernateException e) {

            e.printStackTrace();

        } finally {

            session.close();
        }
    }
}

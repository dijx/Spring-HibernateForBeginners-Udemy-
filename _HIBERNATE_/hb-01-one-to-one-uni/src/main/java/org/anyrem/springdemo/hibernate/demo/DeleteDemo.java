package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Instructor;
import org.hibernate.Session;


public class DeleteDemo {

    public static void main(String[] args) {


        Session session = AppSessionFactory.getSession();

        session.beginTransaction();

        session.delete(session.get(Instructor.class, 1));

        session.getTransaction().commit();

        session.close();

        System.out.println("done");

    }
}

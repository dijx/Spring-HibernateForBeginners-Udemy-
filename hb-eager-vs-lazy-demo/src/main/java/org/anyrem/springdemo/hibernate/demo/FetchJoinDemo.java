package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class FetchJoinDemo {

    public static void main(String[] args) {

        Session session = AppSessionFactory.getSession();

        try {

            session.beginTransaction();

            int theId = 1;

            Query<Instructor> query = session.createQuery(
                    "select i from Instructor i " +
                            "JOIN FETCH i.courses " +
                            "where i.id = :theId",
                    Instructor.class)
                    .setParameter("theId", theId);

            Instructor instructor = query.getSingleResult();

            System.out.println(">>> Instructor details:\n" + instructor);


            session.getTransaction().commit();

            System.out.println(">>> Closing session");
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

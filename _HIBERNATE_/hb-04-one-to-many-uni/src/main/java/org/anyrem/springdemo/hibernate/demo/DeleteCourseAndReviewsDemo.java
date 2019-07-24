package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class DeleteCourseAndReviewsDemo {


    public static void main(String[] args) {

        Session session = AppSessionFactory.getSession();

        try {
            session.beginTransaction();

            int theId = 12;

            Course course1 = session.get(Course.class, theId);

            System.out.println("Course do delete: \n" + course1);

            //deletes also reviews due to cascade.all
            session.delete(course1);

            session.getTransaction().commit();

            System.out.println(">>> Done");

        } catch (HibernateException e) {

            e.printStackTrace();

        } finally {

            session.close();
        }
    }

}

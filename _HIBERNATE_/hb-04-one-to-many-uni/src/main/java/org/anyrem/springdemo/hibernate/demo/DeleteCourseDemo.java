package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Course;
import org.hibernate.Session;


public class DeleteCourseDemo {

    public static void main(String[] args) {

        Session session = AppSessionFactory.getSession();

        try {

            session.beginTransaction();

            int theID = 11;

            Course course = session.get(Course.class, theID);

            session.delete(course);
            session.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            session.close();
        }
    }
}

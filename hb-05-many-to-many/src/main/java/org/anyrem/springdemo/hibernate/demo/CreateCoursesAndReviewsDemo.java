package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.Course;
import org.anyrem.springdemo.hibernate.demo.entity.Review;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class CreateCoursesAndReviewsDemo {


    public static void main(String[] args) {

        Session session = AppSessionFactory.getSession();

        try {
            session.beginTransaction();

            Course course1 = new Course("Pacman - a way to mastery - part two");

            course1.addReview(new Review("Great course! I love it!"));
            course1.addReview(new Review("Review 2"));
            course1.addReview(new Review("Review 3"));
            course1.addReview(new Review("Review 4"));

            //saves also reviews due to cascade.ALL
            session.save(course1);

            System.out.println(">>> Course: \n" + course1);
            System.out.println(">>> Reviews:\n" + course1.getReviews());

            session.getTransaction().commit();

            System.out.println(">>> Done");

        } catch (HibernateException e) {

            e.printStackTrace();

        } finally {

            session.close();
        }
    }

}

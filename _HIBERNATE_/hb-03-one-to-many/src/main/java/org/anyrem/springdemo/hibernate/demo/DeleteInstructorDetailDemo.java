package org.anyrem.springdemo.hibernate.demo;

import org.anyrem.springdemo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;


public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        Session session = AppSessionFactory.getSession();

        try {

            session.beginTransaction();

            int theID = 4;

            InstructorDetail tempDetails = session.get(InstructorDetail.class, theID);

            // SHORT WAY:
            tempDetails.getInstructor().setInstructorDetail(null);

            /*
            // LONG WAY:

            Instructor instructor = tempDetails.getInstructor();
            instructor.setInstructorDetail(null);
            session.save(instructor);
            */

            session.delete(tempDetails);

            session.getTransaction().commit();


        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            session.close();
        }
    }
}

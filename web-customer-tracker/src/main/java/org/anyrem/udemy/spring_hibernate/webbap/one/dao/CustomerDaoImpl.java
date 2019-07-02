package org.anyrem.udemy.spring_hibernate.webbap.one.dao;

import org.anyrem.udemy.spring_hibernate.webbap.one.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

//        Query<Customer> query = session.createQuery("FROM Customer order by lastName", Customer.class);
        Query<Customer> query = session.createQuery("FROM Customer", Customer.class);


        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();
        System.out.println(customer);

        session.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Customer.class, id);
    }

    @Override
    public void delete(int id) {

        Session session = sessionFactory.getCurrentSession();
        session.delete((session.get(Customer.class, id)));
    }
}

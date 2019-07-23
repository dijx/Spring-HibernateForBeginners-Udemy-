package org.anyrem.spring_boot.restcrud.hibarnate_demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }


    @Override
    public Employee findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employee theEmployee =
                currentSession.get(Employee.class, theId);

        // return the employee
        return theEmployee;
    }


    @Override
    public void save(Employee theEmployee) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(theEmployee);
    }


    @Override
    public void deleteById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }

    @Override
    public void deleteObject(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.delete(employee);
    }

    @Override
    public void update(Employee employee) {

        save(employee);
    }
}

/*

import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

//        Session session = entityManager.unwrap(Session.class);
//        final Query query = session.createQuery("FROM Employee", Employee.class);

        final Query query = entityManager.createQuery("SELECT s from Employee s");

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {

        entityManager.persist(employee);
    }

    @Override
    public void deleteObject(Employee employee) {
        entityManager.remove(employee);
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }
}
*/

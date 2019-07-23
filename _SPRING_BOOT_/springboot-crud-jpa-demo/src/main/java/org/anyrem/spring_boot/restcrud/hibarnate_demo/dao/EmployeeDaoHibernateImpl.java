package org.anyrem.spring_boot.restcrud.hibarnate_demo.dao;

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

    @Override
    public void deleteById(int id) {
        entityManager.remove((entityManager.find(Employee.class, id)));
    }
}

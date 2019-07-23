package org.anyrem.spring_boot.restcrud.hibarnate_demo.dao;

import org.anyrem.spring_boot.restcrud.hibarnate_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

//@Primary
@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query query = entityManager.createQuery("from Employee");
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

        Query query = entityManager
                .createQuery("SELECT s FROM Employee s WHERE s.id = :id")
                .setParameter("id", id);
        entityManager.remove(query.getResultList().get(0));
    }

}

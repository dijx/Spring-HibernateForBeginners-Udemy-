package org.anyrem.udemy.spring_hibernate.webbap.one.service;

import org.anyrem.udemy.spring_hibernate.webbap.one.dao.CustomerDao;
import org.anyrem.udemy.spring_hibernate.webbap.one.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> getCustomers() {

        return customerDao.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {

        customerDao.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }

    @Transactional
    @Override
    public void delete(int id) {

        customerDao.delete(id);

    }

    @Transactional
    @Override
    public List<Customer> getByAnyField(String customerString) {

        List<Customer> customersList = new ArrayList<>();

        System.out.println(">>> customerString = " + customerString);

        if (customerString.matches("\\d+")) {

            int customerInt = Integer.parseInt(customerString);

            System.out.println(">>> customerInt = " + customerInt);

            customersList.add(customerDao.getCustomer(customerInt));

        }

        customersList.addAll(customerDao.getByVarcharFields(customerString));

        return customersList;
    }
}

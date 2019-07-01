package org.anyrem.udemy.spring_hibernate.webbap.one.service;

import org.anyrem.udemy.spring_hibernate.webbap.one.dao.CustomerDao;
import org.anyrem.udemy.spring_hibernate.webbap.one.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}

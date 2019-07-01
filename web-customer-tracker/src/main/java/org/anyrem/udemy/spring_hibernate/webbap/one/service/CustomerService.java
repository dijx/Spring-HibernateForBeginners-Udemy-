package org.anyrem.udemy.spring_hibernate.webbap.one.service;

import org.anyrem.udemy.spring_hibernate.webbap.one.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}

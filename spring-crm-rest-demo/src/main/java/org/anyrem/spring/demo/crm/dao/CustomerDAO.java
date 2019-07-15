package org.anyrem.spring.demo.crm.dao;

import java.util.List;

import org.anyrem.spring.demo.crm.entity.Customer;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

}

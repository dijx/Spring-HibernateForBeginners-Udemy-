package org.anyrem.spring.demo.crm.rest;

import org.anyrem.spring.demo.crm.entity.Customer;
import org.anyrem.spring.demo.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(@RequestParam Optional<int[]> id) {

        List<Customer> customers = new ArrayList<>();

        if (id.isPresent()) {

            int[] idArr = id.get();

            for (int i : idArr) {

                try {
                    customers.add(customerService.getCustomer(i));
                } catch (Exception e) {
                    customers.add(new Customer("ID_NOT_RETURNED:" + i, e.getMessage()));
                }
            }
        }

        if (id.isEmpty()) {

            customers = customerService.getCustomers()
                    .stream()
                    .sorted(Comparator.comparing(Customer::getId))
                    .collect(Collectors.toList());
        }

        return customers;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer ID not found: " + customerId);
        }

        return customer;
    }


    @PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public Customer addCustomer(@RequestBody Customer customer) {

        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public Customer updateCustomer(@RequestBody Customer customer, @RequestParam Optional<Integer> id) {

        if (id.isPresent()) {

            int idUsed = id.get();
            customer.setId(idUsed);
        }

        customerService.saveCustomer(customer);
        return customer;

    }

    @DeleteMapping(value = "/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public Customer deleteCustomer(@PathVariable int customerId) {

        Customer toDeleteCustomer = null;

        try {
            toDeleteCustomer = customerService.getCustomer(customerId);

            if (toDeleteCustomer == null) {

                throw new CustomerNotFoundException("Customer ID not found: " + customerId);

            } else {

                customerService.deleteCustomer(customerId);
                return toDeleteCustomer;
            }

        } catch (Exception e) {
            throw new CustomerNotFoundException("Customer ID not found: " + customerId);
        }

    }

}

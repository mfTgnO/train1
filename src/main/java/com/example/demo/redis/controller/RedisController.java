package com.example.demo.redis.controller;

import com.example.demo.redis.model.Customer;
import com.example.demo.redis.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RedisController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/save")
    public String save() {
        // save a single Customer
        customerRepository.save(new Customer(1, "Jack", "Smith"));
        customerRepository.save(new Customer(2, "Adam", "Johnson"));
        customerRepository.save(new Customer(3, "Kim", "Smith"));
        customerRepository.save(new Customer(4, "David", "Williams"));
        customerRepository.save(new Customer(5, "Peter", "Davis"));

        return "Done";
    }

    @RequestMapping("/findAll")
    public String findAll() {
        StringBuilder result = new StringBuilder();
        Map<Long, Customer> customers = customerRepository.findAll();

        for (Customer customer : customers.values()) {
            result.append(customer.toString()).append("<br>");
        }

        return result.toString();
    }

    @RequestMapping("/find")
    public String find(@RequestParam("id") Long id) {
        String result = "";
        result = customerRepository.find(id).toString();
        return result;
    }

    @RequestMapping("/uppercase")
    public String postCustomer(@RequestParam("id") Long id) {
        Customer customer = customerRepository.find(id);
        customer.setFirstName(customer.getFirstName().toUpperCase());
        customer.setLastName(customer.getLastName().toUpperCase());
        customerRepository.update(customer);

        return "Done";
    }

    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") Long id) {
        customerRepository.delete(id);

        return "Done";
    }
}

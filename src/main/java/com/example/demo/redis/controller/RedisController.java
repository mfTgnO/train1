package com.example.demo.redis.controller;

import com.example.demo.redis.model.Customer;
import com.example.demo.redis.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private CustomerRepository customerRepository;

    @Autowired
    public RedisController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/save")
    public String save() {
        // save a single Customer
        customerRepository.save(new Customer(1L, "Jack", "Smith"));
        customerRepository.save(new Customer(2L, "Adam", "Johnson"));
        customerRepository.save(new Customer(3L, "Kim", "Smith"));
        customerRepository.save(new Customer(4L, "David", "Williams"));
        customerRepository.save(new Customer(5L, "Peter", "Davis"));

        return "Done";
    }

    @GetMapping("/findAll")
    public String findAll() {
        StringBuilder result = new StringBuilder();
        Map<Long, Customer> customers = customerRepository.findAll();

        for (Customer customer : customers.values()) {
            result.append(customer.toString()).append("<br>");
        }

        return result.toString();
    }

    @GetMapping("/find")
    public String find(@RequestParam("id") Long id) {
        String result = "";
        result = customerRepository.find(id).toString();
        return result;
    }

    @GetMapping("/uppercase")
    public String postCustomer(@RequestParam("id") Long id) {
        Customer customer = customerRepository.find(id);
//        customer.setFirstName(customer.getFirstName().toUpperCase());
//        customer.setLastName(customer.getLastName().toUpperCase());
        customerRepository.update(customer);

        return "Done";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") Long id) {
        customerRepository.delete(id);

        return "Done";
    }

    @GetMapping("/valueOperationsAdd")
    public String valueOperationsAdd(@RequestParam("key") String key, @RequestParam("value") String value) {
        customerRepository.valueOperationsAdd(key, value);
        return "Done";
    }

    @GetMapping("/valueOperationsAddExpireTime")
    public String valueOperationsAddExpireTime(@RequestParam("key") String key, @RequestParam("value") String value) {
        customerRepository.valueOperationsAddExpireTime(key, value);
        return "Done";
    }

    @GetMapping("/valueOperationsGet")
    public Object valueOperationsGet(@RequestParam("key") String key) {
        return customerRepository.valueOperationsGet(key);
    }

    @GetMapping("/valueOperationsIncrement")
    public Long valueOperationsIncrement(@RequestParam("key") String key) {
        return customerRepository.valueOperationsIncrement(key);
    }

    @GetMapping("/listOperationsRightPush")
    public Long listOperationsRightPush(@RequestParam("key") String key) {
        return customerRepository.listOperationsRightPush(key);
    }

    @GetMapping("/listOperationsRange")
    public List<Object> listOperationsRange(@RequestParam("key") String key) {
        return customerRepository.listOperationsRange(key);
    }

    @GetMapping("/listOperationsSize")
    public Long listOperationsSize(@RequestParam("key") String key) {
        return customerRepository.listOperationsSize(key);
    }

    @GetMapping("/listOperationsLeftPop")
    public Object listOperationsLeftPop(@RequestParam("key") String key) {
        return customerRepository.listOperationsLeftPop(key);
    }

    @GetMapping("/setOperationsAdd")
    public Long setOperationsAdd(@RequestParam("key") String key, @RequestParam("value") Object value) {
        return customerRepository.setOperationsAdd(key, value);
    }

    @GetMapping("/setOperationsMembers")
    public Set<Object> setOperationsMembers(@RequestParam("key") String key) {
        return customerRepository.setOperationsMembers(key);
    }

    @GetMapping("/setOperationsSize")
    public Long setOperationsSize(@RequestParam("key") String key) {
        return customerRepository.setOperationsSize(key);
    }
}

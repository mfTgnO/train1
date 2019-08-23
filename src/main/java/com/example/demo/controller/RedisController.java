package com.example.demo.controller;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import com.example.demo.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author mango
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private CustomerRepository customerRepository;

    @Autowired
    public RedisController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * 保存到redis中
     *
     * @return JsonResult
     */
    @GetMapping("/save")
    public JsonResult save() {
        customerRepository.save(new Customer(1L, "Jack", "Smith"));
        customerRepository.save(new Customer(2L, "Adam", "Johnson"));
        customerRepository.save(new Customer(3L, "Kim", "Smith"));
        customerRepository.save(new Customer(4L, "David", "Williams"));
        customerRepository.save(new Customer(5L, "Peter", "Davis"));

        return new JsonResult();
    }

    /**
     * 查询redis中的所有Customer
     *
     * @return JsonResult
     */
    @GetMapping("/findAll")
    public JsonResult findAll() {
        Map<Object, Object> customers = customerRepository.findAll();

        return new JsonResult(customers);
    }

    /**
     * 根据id查询Customer
     *
     * @return JsonResult
     */
    @GetMapping("/findById")
    public JsonResult<Customer> findById(@RequestParam("id") Long id) {
        Customer customer = customerRepository.find(id);
        return new JsonResult<>(customer);
    }

    /**
     * 更新Customer
     *
     * @return JsonResult
     */
    @PutMapping("/update")
    public JsonResult postCustomer(@RequestParam("id") Long id,
                                   @RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName) {
        Customer customer = customerRepository.find(id);
        if (StringUtils.isNotEmpty(firstName)) {
            customer.setFirstName(firstName);
        }
        if (StringUtils.isNotEmpty(lastName)) {
            customer.setLastName(lastName);
        }
        customerRepository.update(customer);

        return new JsonResult();
    }

    /**
     * 删除Customer
     *
     * @return JsonResult
     */
    @DeleteMapping("/delete")
    public JsonResult deleteById(@RequestParam("id") Long id) {
        customerRepository.delete(id);

        return new JsonResult();
    }

    /**
     * @return JsonResult
     */
    @GetMapping("/valueOperationsAdd")
    public JsonResult valueOperationsAdd(@RequestParam("key") String key,
                                         @RequestParam("value") String value) {
        customerRepository.valueOperationsAdd(key, value);
        return new JsonResult();
    }

    @GetMapping("/valueOperationsAddExpireTime")
    public JsonResult valueOperationsAddExpireTime(@RequestParam("key") String key,
                                                   @RequestParam("value") String value) {
        customerRepository.valueOperationsAddExpireTime(key, value);
        return new JsonResult();
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
    public List<String> listOperationsRange(@RequestParam("key") String key) {
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
    public Long setOperationsAdd(@RequestParam("key") String key, @RequestParam("value") String value) {
        return customerRepository.setOperationsAdd(key, value);
    }

    @GetMapping("/setOperationsMembers")
    public Set<String> setOperationsMembers(@RequestParam("key") String key) {
        return customerRepository.setOperationsMembers(key);
    }

    @GetMapping("/setOperationsSize")
    public Long setOperationsSize(@RequestParam("key") String key) {
        return customerRepository.setOperationsSize(key);
    }
}

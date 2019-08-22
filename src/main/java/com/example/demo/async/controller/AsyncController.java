package com.example.demo.async.controller;

import com.example.demo.async.model.EmployeeAddresses;
import com.example.demo.async.model.EmployeeNames;
import com.example.demo.async.model.EmployeePhone;
import com.example.demo.async.service.AsyncService;
import com.example.demo.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/testAsynch")
    public JsonResult testAsync() throws InterruptedException, ExecutionException {
        // Start the clock
        long start = System.currentTimeMillis();
        log.info("testAsync Start");

        CompletableFuture<EmployeeAddresses> employeeAddresses = asyncService.getEmployeeAddresses();
        CompletableFuture<EmployeeNames> employeeNames = asyncService.getEmployeeNames();
        CompletableFuture<EmployeePhone> employeePhone = asyncService.getEmployeePhone();

        CompletableFuture.allOf(employeeAddresses, employeeNames, employeePhone).join();

        // Print results, including elapsed time
        log.info("Elapsed time: " + (System.currentTimeMillis() - start));
        log.info("EmployeeAddress--> " + employeeAddresses.get());
        log.info("EmployeeName--> " + employeeNames.get());
        log.info("EmployeePhone--> " + employeePhone.get());
        return new JsonResult();
    }
}

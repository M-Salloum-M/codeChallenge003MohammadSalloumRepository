package com.example.CodeChallenge003MohammadSalloum.controller;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
import com.example.CodeChallenge003MohammadSalloum.service.CustomerService;
import com.example.CodeChallenge003MohammadSalloum.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;
    @Autowired
    ValidateNumberController validateNumberController;
    @Autowired
    RabbitMQSender rabbitMQSender;

    @Cacheable(value = "customers", key = "#id")
    @GetMapping("/getAll")
    List<Customer> getAll() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }
    @Cacheable(value = "customers", key = "#id")
    @GetMapping("/{id}")
    Optional<Customer> get(@PathVariable UUID id) {
        Optional<Customer> customer = customerService.findById(id);
        return customer;
    }
    @CachePut(value = "customers", key = "#id")
    @PostMapping
    Customer newOne(@RequestBody Customer t) {
        ResponseEntity<?> responseEntity = validateNumberController.validate(t.getMobileNumber());
        if (responseEntity.getStatusCode().isError()) {
            return null;
        } else {
            rabbitMQSender.send(t);
            return customerService.save(t);
        }
    }
    @CachePut(value = "customers", key = "#customers.id")
    @PutMapping
    Customer update(@RequestBody Customer t) {
        ResponseEntity<?> responseEntity = validateNumberController.validate(t.getMobileNumber());
        if (responseEntity.getStatusCode().isError()) {
            return null;
        } else
            return customerService.save(t);
    }
    @CacheEvict(value = "customers", allEntries=true)
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        customerService.deleteById(id);
    }


}

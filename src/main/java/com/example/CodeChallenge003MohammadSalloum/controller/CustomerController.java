package com.example.CodeChallenge003MohammadSalloum.controller;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
//import com.example.CodeChallenge003MohammadSalloum.RedisCustomerRepository;
import com.example.CodeChallenge003MohammadSalloum.repository.RedisCustomerRepository;
//import com.example.CodeChallenge003MohammadSalloum.service.CustomerService;
import com.example.CodeChallenge003MohammadSalloum.service.RabbitMQSender;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {


//    @Autowired
//    CustomerService customerService;
    @Autowired
    ValidateNumberController validateNumberController;
    @Autowired
    RabbitMQSender rabbitMQSender;
    @Autowired
    RedisCustomerRepository redisCustomerRepository;

    public CustomerController(RedisCustomerRepository redisCustomerRepository) {
        this.redisCustomerRepository = redisCustomerRepository;
    }

//    @Cacheable(value = "customers", key = "#id")
    @GetMapping("/getAll")
    Iterable<Customer> getAll() {
//        List<Customer> customers = customerService.findAll();

        return redisCustomerRepository.findAll();
    }
//    @Cacheable(value = "customers", key = "#id")
    @GetMapping("/{id}")
    Optional<Customer> get(@PathVariable String id) {
       // Optional<Customer> customer = customerService.findById(id);
        Optional<Customer> customer = redisCustomerRepository.findById(id);
        return customer;
    }
//    @CachePut(value = "customers", key = "#id")
    @PostMapping
    void newOne(@RequestBody Customer t) {
        ResponseEntity<?> responseEntity = validateNumberController.validate(t.getMobileNumber());
        if (responseEntity.getStatusCode().isError()) {
            System.out.println("ERROR");
//            return null;
        } else {
            rabbitMQSender.send(t);
            redisCustomerRepository.save(t);
            System.out.println(t.toString());
            //return customerService.save(t);

        }
    }
//    @CachePut(value = "customers", key = "#customers.id")
    @PutMapping
    void update(@RequestBody Customer t) {
        ResponseEntity<?> responseEntity = validateNumberController.validate(t.getMobileNumber());
        if (responseEntity.getStatusCode().isError()) {
            System.out.println("ERROR");
//            return null;
        } else{
            rabbitMQSender.send(t);
            redisCustomerRepository.save(t);
            System.out.println(t.toString());
        }
            //return customerService.save(t);
    }
//    @CacheEvict(value = "customers", allEntries=true)
    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        Optional<Customer> customer = redisCustomerRepository.findById(id);

//        customerService.deleteById(id);
        redisCustomerRepository.delete(customer.get());
        System.out.println(id+" Deleted");
    }


}

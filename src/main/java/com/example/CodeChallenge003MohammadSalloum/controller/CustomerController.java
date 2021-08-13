package com.example.CodeChallenge003MohammadSalloum.controller;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
import com.example.CodeChallenge003MohammadSalloum.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ValidateNumberController validateNumberController;


    @GetMapping("/getAll")
    List<Customer> getAll(){
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    @PostMapping
    Customer newOne(@RequestBody Customer t) {
        ResponseEntity<?> responseEntity = validateNumberController.validate(t.getMobileNumber());
        if(responseEntity.getStatusCode().isError()){
            return null;
        }else
        return customerService.save(t);
    }

    @PutMapping
    Customer update(@RequestBody Customer t) {
        ResponseEntity<?> responseEntity = validateNumberController.validate(t.getMobileNumber());
        if(responseEntity.getStatusCode().isError()){
            return null;
        }else
        return customerService.save(t);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        customerService.deleteById(id);
    }
}

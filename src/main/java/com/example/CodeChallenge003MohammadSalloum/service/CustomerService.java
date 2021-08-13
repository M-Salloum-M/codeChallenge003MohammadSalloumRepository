package com.example.CodeChallenge003MohammadSalloum.service;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
import com.example.CodeChallenge003MohammadSalloum.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;


    public Customer save(Customer newT) {
        return repository.save(newT);
    }

    public Optional<Customer> findById(UUID id) {
        return repository.findById(id);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}

package com.example.CodeChallenge003MohammadSalloum.repository;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisCustomerRepository extends CrudRepository<Customer, String> {
}

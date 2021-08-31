//package com.example.CodeChallenge003MohammadSalloum;
//
//import com.example.CodeChallenge003MohammadSalloum.model.Customer;
//import com.example.CodeChallenge003MohammadSalloum.RedisCustomerRepository;
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import netscape.javascript.JSObject;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//@Repository
//public class RedisCustomerRepositoryImpl implements RedisCustomerRepository {
//
//    private RedisTemplate<String, Customer> redisTemplate;
//
//    private HashOperations hashOperations;
//
//    public RedisCustomerRepositoryImpl(RedisTemplate<String, Customer> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//
//        hashOperations = redisTemplate.opsForHash();
//    }
//
//    @Override
//    public void save(Customer customer) {
//        hashOperations.put("CUSTOMER", customer.getId(), customer);
//    }
//
//   @Override
//    public List findAll() {
//        return hashOperations.values("CUSTOMER");
//    }
//
//   @Override
//    public Customer findById(String id) {
//        return (Customer) hashOperations.get("CUSTOMER", id);
//    }
//
//    @Override
//    public void update(Customer customer) {
//        save(customer);
//    }
//
//    @Override
//    public void delete(String id) {
//
//        hashOperations.delete("CUSTOMER", id);
//    }
//}

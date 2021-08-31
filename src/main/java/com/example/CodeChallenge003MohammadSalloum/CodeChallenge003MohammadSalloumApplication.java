package com.example.CodeChallenge003MohammadSalloum;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootApplication
//@EnableCaching
public class CodeChallenge003MohammadSalloumApplication {

//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		return new JedisConnectionFactory();
//	}
//
//	@Bean
//	 RedisTemplate<String, Customer> redisTemplate() {
//		RedisTemplate<String, Customer> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(jedisConnectionFactory());
//		return redisTemplate;
//	}

	public static void main(String[] args) {
		SpringApplication.run(CodeChallenge003MohammadSalloumApplication.class);
	}
	}


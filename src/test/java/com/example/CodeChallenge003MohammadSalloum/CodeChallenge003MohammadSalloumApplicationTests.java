package com.example.CodeChallenge003MohammadSalloum;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CodeChallenge003MohammadSalloumApplicationTests {

	@Test
	void contextLoads() {

		Customer customer = new Customer();
		customer.setAddress("Beirut");
		customer.setMobileNumber("+96171307046");
		customer.setName("mohammad");


		assertEquals("Beirut", customer.getAddress());
		assertEquals("+96171307046", customer.getMobileNumber());
		assertEquals("mohammad", customer.getName());
	}

}

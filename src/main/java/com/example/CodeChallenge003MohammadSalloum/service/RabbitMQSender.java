package com.example.CodeChallenge003MohammadSalloum.service;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Customer customer) {
        rabbitTemplate.convertAndSend(exchange, routingkey, customer);
        System.out.println("Send msg = " + customer);
    }
}



package com.example.rabbitmqListener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMQListner implements MessageListener {

    public void onMessage(Message message) {
        System.out.println("Receiving message - " + new String(message.getBody()));
    }


}

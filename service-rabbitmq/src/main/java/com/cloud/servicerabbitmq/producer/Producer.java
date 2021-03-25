package com.cloud.servicerabbitmq.producer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-26-2021 00:37:26
 * @description :  生产者
 * @since :  v1.0
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String exchange = "hello-exchange";
        channel.exchangeDeclare(exchange, "direct", true);

        String routeKey = "hola";
        byte[] messageBodyBytes = "quit".getBytes();
        channel.basicPublish(exchange, routeKey, null, messageBodyBytes);
        channel.close();
        connection.close();
    }
}

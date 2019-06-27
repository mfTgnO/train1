package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @package: com.example.demo.config
 * @author:
 * @email:
 * @createDate: 2019-06-27 17:54
 * @description: https://sivalabs.in/2018/02/springboot-messaging-rabbitmq/
 */
@Configuration
public class RabbitConfig {
    public static final String QUEUE_ORDERS = "orders-queue";
    public static final String EXCHANGE_ORDERS = "orders-exchange";

    @Bean
    Queue ordersQueue() {
        return QueueBuilder.durable(QUEUE_ORDERS).build();
    }

    /*@Bean
    Queue deadLetterQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_ORDERS).build();
    }*/

    @Bean
    Exchange ordersExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_ORDERS).build();
    }

    @Bean
    Binding binding(Queue ordersQueue, TopicExchange ordersExchange) {
        return BindingBuilder.bind(ordersQueue).to(ordersExchange).with(QUEUE_ORDERS);
    }
}

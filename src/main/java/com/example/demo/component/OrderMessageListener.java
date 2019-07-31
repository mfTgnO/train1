package com.example.demo.component;

import com.example.demo.model.OrderMQ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @package: com.example.demo.rabbitmq
 * @author:
 * @email:
 * @createDate: 2019-06-28 10:02
 * @description:
 */
@Component
@Slf4j
public class OrderMessageListener {
    //    @RabbitListener(queues = RabbitConfig.ROUTING_KEY)
    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void processOrder(OrderMQ orderMQ) {
        log.info("Order Received: " + orderMQ);
    }
}

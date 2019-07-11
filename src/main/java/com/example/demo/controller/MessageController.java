package com.example.demo.controller;

import com.example.demo.model.OrderMQ;
import com.example.demo.service.impl.OrderMessageSender;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

/**
 * @package: com.example.demo.rabbitmq
 * @author:
 * @email:
 * @createDate: 2019-06-28 10:04
 * @description:
 */
@RestController
@RequestMapping
public class MessageController {
    private final OrderMessageSender orderMessageSender;

    @Autowired
    public MessageController(OrderMessageSender orderMessageSender) {
        this.orderMessageSender = orderMessageSender;
    }

    @PostMapping("/sendMsg")
    public JsonResult handleMessage(OrderMQ orderMQ, RedirectAttributes redirectAttributes, Model model) {
        int times = 1 << 10;
        for (int i = 0; i < times; i++) {
            orderMessageSender.snedOrder(orderMQ);
            redirectAttributes.addFlashAttribute("message", "Order message sent successfully");
        }
        return new JsonResult();
    }

    @PostMapping("/sendMsgV2")
    public JsonResult handleMessageV2() {
        Random random = new Random();
        int times = 1 << 10;
        for (int i = 0; i < times; i++) {
            OrderMQ orderMQ = new OrderMQ();
            orderMQ.setProductId(String.valueOf(i));
            orderMQ.setOrderNumber(String.valueOf(i));
            orderMQ.setAmount(random.nextInt(100));

            orderMessageSender.snedOrder(orderMQ);
        }
        return new JsonResult();
    }
}

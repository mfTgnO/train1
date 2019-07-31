package com.example.demo.controller;

import com.example.demo.model.OrderMQ;
import com.example.demo.service.MessageService;
import com.example.demo.service.impl.OrderMessageSender;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.annotation.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
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
    private final MessageService messageService;

    @Autowired
    public MessageController(OrderMessageSender orderMessageSender, MessageService messageService) {
        this.orderMessageSender = orderMessageSender;
        this.messageService = messageService;
    }

    /**
     * @param orderMQ
     * @return JsonResult
     */
    @PostMapping("/sendMsg")
    public JsonResult handleMessage(@ModelAttribute OrderMQ orderMQ) {
        boolean save = messageService.save(orderMQ);
        if (save) {
            return new JsonResult();
        }
        return new JsonResult.Builder().build(JsonResult.Code.FAIL);
    }

    /**
     * 发送消息
     * @return JsonResult
     */
    @PostMapping("/sendMsgV2")
    public JsonResult handleMessageV2() {
        Random random = new Random(1000);
        // 发送消息条数
        int times = 1 << 1;
        for (int i = 0; i < times; i++) {
            OrderMQ orderMQ = new OrderMQ();
            orderMQ.setProductId((long) i);
            orderMQ.setOrderNumber(random.nextLong());
            orderMQ.setAmount(new BigDecimal(random.nextLong()));

            orderMessageSender.sendOrder(orderMQ);
        }
        return new JsonResult();
    }

    @GetMapping
    @PageHelp
    public JsonResult list() {
        List<OrderMQ> list = messageService.list();
        return new JsonResult(list);
    }
}

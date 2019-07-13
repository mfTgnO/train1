package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.model.OrderMQ;
import com.example.demo.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * @package: com.example.demo.service.impl
 * @author:
 * @email:
 * @createDate: 2019-07-13 10:40
 * @description:
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, OrderMQ> implements MessageService {
}

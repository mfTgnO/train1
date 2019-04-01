package com.example.demo.dao.impl;

import com.example.demo.dao.OrderRepository;
import com.example.demo.domain.Order_ch03;
import com.example.demo.domain.Taco_ch03;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order");

        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");

        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Order_ch03 save(Order_ch03 order_ch03) {
        order_ch03.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order_ch03);
        order_ch03.setId(orderId);
        List<Taco_ch03> tacos = order_ch03.getTacos();
        for (Taco_ch03 taco : tacos) {
            saveTacoOrder(taco, orderId);
        }
        return order_ch03;
    }

    private long saveOrderDetails(Order_ch03 order_ch03) {
        @SuppressWarnings("unchecked")
        Map map = objectMapper.convertValue(order_ch03, Map.class);
        map.put("placedAt", order_ch03.getPlacedAt());

        long orderId = orderInserter
                .executeAndReturnKey(map)
                .longValue();
        return orderId;
    }

    private void saveTacoOrder(Taco_ch03 taco_ch03, long orderId) {
        HashMap<String, Object> values = new HashMap<>();
        values.put("tacoOrder", orderId);
        values.put("taco", taco_ch03.getId());
        orderTacoInserter.execute(values);
    }
}

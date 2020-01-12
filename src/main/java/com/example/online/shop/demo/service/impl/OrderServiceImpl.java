package com.example.online.shop.demo.service.impl;

import com.example.online.shop.demo.dao.Order;
import com.example.online.shop.demo.repository.OrderRepository;
import com.example.online.shop.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


}

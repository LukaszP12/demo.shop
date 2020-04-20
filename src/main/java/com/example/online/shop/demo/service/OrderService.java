package com.example.online.shop.demo.service;

import com.example.online.shop.demo.model.dao.Order;
import com.example.online.shop.demo.repository.OrderRepository;

import java.util.List;

public interface OrderService {

    void save();

    List<OrderRepository.GrouppedOrders> getSumOrder();

    List<Order> getOrderByCode(String code);

}

package com.example.online.shop.demo.service;

import com.example.online.shop.demo.dao.Order;

import java.util.List;

public interface OrderService {

    void saveById(Long id);

    List<Order> orderByCustomerId(Long id);

}

package com.example.online.shop.demo.service.impl;

import com.example.online.shop.demo.dao.Basket;
import com.example.online.shop.demo.dao.Order;
import com.example.online.shop.demo.dao.Product;
import com.example.online.shop.demo.repository.BasketRepository;
import com.example.online.shop.demo.repository.OrderRepository;
import com.example.online.shop.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Override
    public void saveById(Long id) {
       List<Basket> basketList = basketRepository.findByCustomerId(id);
       
    }

    @Override
    public List<Order> orderByCustomerId(Long id) {
        return orderRepository.findByCustomerId(id);
    }




}

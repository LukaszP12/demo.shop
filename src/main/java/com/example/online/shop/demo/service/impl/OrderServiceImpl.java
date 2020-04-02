package com.example.online.shop.demo.service.impl;

import com.example.online.shop.demo.dao.Basket;
import com.example.online.shop.demo.dao.Order;
import com.example.online.shop.demo.dao.Product;
import com.example.online.shop.demo.repository.BasketRepository;
import com.example.online.shop.demo.repository.OrderRepository;
import com.example.online.shop.demo.service.BasketService;
import com.example.online.shop.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private BasketService basketService;

    @Override
    public void saveById(Long id) {
        List<Basket> basketList = basketRepository.findByCustomerId(id);
        String orderCode = UUID.randomUUID().toString();
        orderRepository.saveAll(basketList.stream().map(basket -> Order.builder()
                .product(basket.getProduct())
                .customer(basket.getCustomer())
                .quantity(basket.getQuantity())
                .code(orderCode)
                .sumPrice(basket.getQuantity() * basket.getProduct().getPrice())
                .build()).collect(Collectors.toList()));

        basketList.forEach(basket -> basketRepository.deleteById(basket.getId()));
    }

    //order by code


    public void deleteById(Long id) {
        basketService.deleteById(id);
    }

    @Override
    public List<Order> orderByCustomerId(Long id) {
        return orderRepository.findByCustomerId(id);
    }


}

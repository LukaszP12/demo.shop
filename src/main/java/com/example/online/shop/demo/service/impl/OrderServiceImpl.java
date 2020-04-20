package com.example.online.shop.demo.service.impl;

import com.example.online.shop.demo.model.dao.Basket;
import com.example.online.shop.demo.model.dao.Order;
import com.example.online.shop.demo.repository.BasketRepository;
import com.example.online.shop.demo.repository.OrderRepository;
import com.example.online.shop.demo.service.BasketService;
import com.example.online.shop.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public void save() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        List<Basket> basketList = basketRepository.findByCustomerEmail(email);
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

    }

    @Override
    public List<OrderRepository.GrouppedOrders> getSumOrder() {
        return orderRepository.getSumOrder(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public List<Order> getOrderByCode(String code) {
        return orderRepository.findByCode(code);
    }


}

package com.example.online.shop.demo.controller;


import com.example.online.shop.demo.model.dao.Order;
import com.example.online.shop.demo.repository.OrderRepository;
import com.example.online.shop.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderRepository.GrouppedOrders> getOrders(){
        return orderService.getSumOrder();
    }

    @PostMapping
    public void saveOrder(){
            orderService.save();
    }

    @GetMapping("/details")
    public List<Order> getOrdersByCode(@RequestParam String code){
        return orderService.getOrderByCode(code);
    }

}

package com.example.online.shop.demo.controller;


import com.example.online.shop.demo.dao.Order;
import com.example.online.shop.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders(@RequestParam Long id){
        return orderService.orderByCustomerId(id);
    }

    @PostMapping
    public void saveOrder(@RequestParam Long id){

    }

}

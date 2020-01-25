package com.example.online.shop.demo.controller;

import com.example.online.shop.demo.dao.Basket;
import com.example.online.shop.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/basket")
public class BasketController {
    @Autowired
    private BasketService basketService;

    @PostMapping
    public Basket saveBasket(@RequestBody Basket basket){
        return basketService.addToBasket(basket);
    }



}

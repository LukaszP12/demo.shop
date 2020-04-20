package com.example.online.shop.demo.controller;

import com.example.online.shop.demo.model.dao.Basket;
import com.example.online.shop.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basket")
@PreAuthorize("isAuthenticated()")
public class BasketController {
    @Autowired
    private BasketService basketService;

    @PostMapping
    public Basket saveBasket(@RequestBody Basket basket){
        return basketService.addToBasket(basket);
    }

    @GetMapping
    public List<Basket> getBasketById(){return basketService.getBasketByUserId(); }

    @PutMapping
    public void updateBasket(@RequestBody Basket newBasket){

    };

    @DeleteMapping("/{productId}")
    public void deleteBasketById(@PathVariable Long productId){ basketService.deleteByProductId(productId);}

}

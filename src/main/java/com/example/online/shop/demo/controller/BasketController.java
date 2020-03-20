package com.example.online.shop.demo.controller;

import com.example.online.shop.demo.dao.Basket;
import com.example.online.shop.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/basket")
public class BasketController {
    @Autowired
    private BasketService basketService;

    @PostMapping
    public Basket saveBasket(@RequestBody Basket basket){
        return basketService.addToBasket(basket);
    }

    @GetMapping
    public List<Basket> getBasketById(@RequestParam Long id){return basketService.getBasketByUserId(id); }

    @PutMapping("/{id}")
    public void updateBasket(@PathVariable Long id, @RequestBody Basket newBasket){
                   List<Basket> basketList = basketService.getBasketByUserId(id);

    };

    @DeleteMapping
    public void deleteBasketById(@RequestParam Long id){ basketService.deleteById(id);}

}

package com.example.online.shop.demo.service;

import com.example.online.shop.demo.dao.Basket;

import java.util.List;

public interface BasketService {

    Basket addToBasket(Basket basket);

    List<Basket> getAll();

    void deleteById(Long id);

    List<Basket> getBasketByUserId(Long id);



}

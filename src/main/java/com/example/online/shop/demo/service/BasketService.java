package com.example.online.shop.demo.service;

import com.example.online.shop.demo.model.dao.Basket;

import java.util.List;

public interface BasketService {

    Basket addToBasket(Basket basket);

    List<Basket> getAll();

    void deleteByProductId(Long id);

    List<Basket> getBasketByUserId();

     Basket updateBasket(Basket basket);



}

package com.example.online.shop.demo.repository;

import com.example.online.shop.demo.dao.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Long> {
     Basket findByProductId(Long id);

}

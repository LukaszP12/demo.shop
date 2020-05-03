package com.example.online.shop.demo.repository;

import com.example.online.shop.demo.model.dao.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket,Long> {
     Basket findByProductId(Long id);

     List<Basket> findByCustomerId(Long id);

    void deleteByProductId(Long productId);

    List<Basket> findByCustomerEmail(String email);

    Optional<Basket> findByCustomerEmailAndProductId(String email, Long productId);

}

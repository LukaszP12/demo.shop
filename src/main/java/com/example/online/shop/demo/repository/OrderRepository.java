package com.example.online.shop.demo.repository;

import com.example.online.shop.demo.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

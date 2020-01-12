package com.example.online.shop.demo.repository;

import com.example.online.shop.demo.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}

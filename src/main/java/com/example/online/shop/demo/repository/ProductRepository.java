package com.example.online.shop.demo.repository;

import com.example.online.shop.demo.model.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

        @Query(value = "select name " +
                "from product " +
                "where name like %?1%  ",nativeQuery = true)

        List<String> getProductName(String name);



}

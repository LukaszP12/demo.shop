package com.example.online.shop.demo.service;


import com.example.online.shop.demo.model.dao.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    List<Product> getAll();

    Page<Product> getPage(Pageable of);

    void deleteById(Long id);

    Optional<Product> findByProductId(Long id);

    Product updateProduct(Product product,Long id);

    List<String> autoComplete(String name);

}

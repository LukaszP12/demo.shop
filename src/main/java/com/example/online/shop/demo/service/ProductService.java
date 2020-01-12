package com.example.online.shop.demo.service;


import com.example.online.shop.demo.dao.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> getAll();

    Page<Product> getPage(Pageable of);

    void deleteById(Long id);

}

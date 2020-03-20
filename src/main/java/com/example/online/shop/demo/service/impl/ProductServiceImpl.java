package com.example.online.shop.demo.service.impl;

import com.example.online.shop.demo.dao.Product;
import com.example.online.shop.demo.repository.ProductRepository;
import com.example.online.shop.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getPage(Pageable of) {
        return productRepository.findAll(of);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findByProductId(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Product product,Long id) {
        Optional<Product> dbProduct = findByProductId(id);
        return dbProduct.map(product1 -> {
            product1.setDescription(product.getDescription());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setQuantity(product.getQuantity());
            return productRepository.save(product1);
        }).orElseThrow(EntityNotFoundException::new);
    }


}

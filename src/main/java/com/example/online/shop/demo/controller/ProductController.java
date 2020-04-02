package com.example.online.shop.demo.controller;

import com.example.online.shop.demo.dao.Product;
import com.example.online.shop.demo.service.OrderService;
import com.example.online.shop.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/all")
    public List<Product> getProducts(){
        return productService.getAll();
    }

    @GetMapping
    public Page<Product> getPageProduct(@RequestParam int page,@RequestParam int size){return productService.getPage(PageRequest.of(page,size)); }

    @GetMapping("/autocomplete")
    public List<String> autoComplete(@RequestParam String name){
        return productService.autoComplete(name);
    }

    @DeleteMapping
    public void deleteProductById(@RequestParam Long id){
        productService.deleteById(id);
    }

    @PutMapping
    public Product updateProductById(@RequestBody Product newProduct,@RequestParam Long id) {
            return productService.updateProduct(newProduct,id);
    }



}

package com.example.online.shop.demo.controller;

import com.example.online.shop.demo.model.dao.Product;
import com.example.online.shop.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
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
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProductById(@RequestParam Long id){
        productService.deleteById(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateProductById(@RequestBody Product newProduct,@RequestParam Long id) {
            return productService.updateProduct(newProduct,id);
    }

}

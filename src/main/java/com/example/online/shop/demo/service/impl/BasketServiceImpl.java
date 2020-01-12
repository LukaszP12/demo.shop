package com.example.online.shop.demo.service.impl;

import com.example.online.shop.demo.dao.Basket;
import com.example.online.shop.demo.dao.Customer;
import com.example.online.shop.demo.dao.Product;
import com.example.online.shop.demo.repository.BasketRepository;
import com.example.online.shop.demo.repository.CustomerRepository;
import com.example.online.shop.demo.repository.ProductRepository;
import com.example.online.shop.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Basket addToBasket(Basket basket) {
        Optional<Product> productOptional = productRepository.findById(basket.getProduct().getId());
        Optional<Customer> customerOptional = customerRepository.findById(basket.getCustomer().getId());
        if (productOptional.isPresent() & customerOptional.isPresent()){
            Product product = productOptional.get();
            Customer customer = customerOptional.get();

            if (basket.getQuantity() >= product.getQuantity()){
                basket.setCustomer(customer);
                basket.setProduct(product);
                return basketRepository.save(basket);
            }else if (basket.getQuantity() > product.getQuantity()){
                basket.setQuantity((product.getQuantity()));
            }
        }



        return basketRepository.save(basket);
    }

    @Override
    public List<Basket> getAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

}

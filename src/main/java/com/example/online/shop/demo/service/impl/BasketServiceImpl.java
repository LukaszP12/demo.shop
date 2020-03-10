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

import javax.persistence.EntityNotFoundException;
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

            Basket basket1 = basketRepository.findByProductId(product.getId());
            if (basket1 == null){

            if (basket.getQuantity() >= product.getQuantity()){
                basket.setQuantity(product.getQuantity());
                basket.setCustomer(customer);
                basket.setProduct(product);
                return basketRepository.save(basket);
            }
            basket.setCustomer(customer);
            basket.setProduct(product);
            return basketRepository.save(basket);
            }else {
               if( basket1.getQuantity() + basket.getQuantity() >= product.getQuantity() ){
                   basket1.setQuantity(product.getQuantity());
                   return basketRepository.save(basket1);
               }
               basket1.setQuantity(basket1.getQuantity() + basket.getQuantity());
               return basketRepository.save(basket1);
            }
        }
        throw new EntityNotFoundException();

    }

    @Override
    public List<Basket> getAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        basketRepository.deleteById(id);
    }

    @Override
    public List<Basket> getBasketByUserId(Long id) {
        return basketRepository.findByCustomerId(id);
    }



}

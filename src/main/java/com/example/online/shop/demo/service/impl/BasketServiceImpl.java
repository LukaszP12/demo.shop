package com.example.online.shop.demo.service.impl;

import com.example.online.shop.demo.model.dao.Basket;
import com.example.online.shop.demo.model.dao.Customer;
import com.example.online.shop.demo.model.dao.Product;
import com.example.online.shop.demo.repository.BasketRepository;
import com.example.online.shop.demo.repository.CustomerRepository;
import com.example.online.shop.demo.repository.ProductRepository;
import com.example.online.shop.demo.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    private final ProductRepository productRepository;

    private final CustomerRepository customerRepository;

    @Override
    public Basket addToBasket(Basket basket) {
        Optional<Product> productOptional = productRepository.findById(basket.getProduct().getId());
        Optional<Customer> customerOptional = customerRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
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
    public void deleteByProductId(Long productId) {
        basketRepository.deleteByProductId(productId);
    }

    @Override
    public List<Basket> getBasketByUserId() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return basketRepository.findByCustomerEmail(email);
    }

    @Override
    public Basket updateBasket(Basket basket) {
        Optional<Basket> optionalBasket = basketRepository.findByCustomerEmailAndProductId(SecurityContextHolder.getContext().getAuthentication().getName(), basket.getProduct().getId());
        if (optionalBasket.isPresent()){
            Basket basketDB = optionalBasket.get();
            basketDB.setQuantity(basket.getQuantity());
            return basketRepository.save(basketDB);
        } else {
            return addToBasket(basket);
        }

    }

}

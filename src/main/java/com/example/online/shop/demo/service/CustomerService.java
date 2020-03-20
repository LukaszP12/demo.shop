package com.example.online.shop.demo.service;

import com.example.online.shop.demo.dao.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getAll();

    void deleteById(Long id);

    Optional<Customer> findById(Long id);

}

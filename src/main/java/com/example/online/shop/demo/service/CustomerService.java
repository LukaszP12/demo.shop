package com.example.online.shop.demo.service;

import com.example.online.shop.demo.dao.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getAll();

    void deleteById(Long id);

}

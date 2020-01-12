package com.example.online.shop.demo.controller;

import com.example.online.shop.demo.dao.Customer;
import com.example.online.shop.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @DeleteMapping
    public void deleteCustomerById(@RequestParam Long id) {
        customerService.deleteById(id);
    }

}

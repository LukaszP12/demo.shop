package com.example.online.shop.demo.controller;

import com.example.online.shop.demo.model.dao.Customer;
import com.example.online.shop.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PreAuthorize("hasRole('ADMIN')")
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCustomerById(@RequestParam Long id) {
        customerService.deleteById(id);
    }

    // przeniesc metode do service
    @PutMapping("/{id}")
    public void updateCustomerById(@RequestBody Customer newCustomer, @PathVariable Long id){
         Optional<Customer> customer = customerService.findById(id);
         customer.ifPresent(customer1 -> {
                    customer1.setId(newCustomer.getId());
                    customer1.setRolesList(newCustomer.getRolesList());
                    customer1.setEmail(newCustomer.getEmail());
                    customer1.setName(newCustomer.getName());
                    customer1.setSurname(newCustomer.getSurname());
                    customer1.setPassword(newCustomer.getPassword());
                 }
         );
    }

}

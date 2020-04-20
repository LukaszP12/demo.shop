package com.example.online.shop.demo.service.impl;

import com.example.online.shop.demo.model.dao.Customer;
import com.example.online.shop.demo.repository.CustomerRepository;
import com.example.online.shop.demo.repository.RoleRepository;
import com.example.online.shop.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Customer save(Customer customer) {
        roleRepository.findByName("ROLE_USER").ifPresent(role -> customer.setRolesList(Arrays.asList(role)));
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

}

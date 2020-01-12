package com.example.online.shop.demo.repository;

import com.example.online.shop.demo.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}

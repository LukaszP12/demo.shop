package com.example.online.shop.demo.model.dto;

import com.example.online.shop.demo.model.dao.Customer;
import com.example.online.shop.demo.model.dao.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class BasketDto {

    private Long id;
    private Product product;
    private Customer customer;
    private int quantity;


    }







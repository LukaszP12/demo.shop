package com.example.online.shop.demo.model.dto;


import com.example.online.shop.demo.model.dao.Customer;
import com.example.online.shop.demo.model.dao.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    private Long id;
    private int quantity;
    private LocalDateTime createdDate;
    private Customer customer;
    private Product product;
    private String code;
    private double sumPrice;



}

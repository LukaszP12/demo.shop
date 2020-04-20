package com.example.online.shop.demo.model.dao;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> rolesList;

    //private List<Order> orders = new ArrayList<Order>();


}

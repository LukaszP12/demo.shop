package com.example.online.shop.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;


}

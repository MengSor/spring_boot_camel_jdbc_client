package com.example.spring_boot_camel_jdbc_client.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Products {
    private Long pro_id;
    private String name;
    private Double price;
}

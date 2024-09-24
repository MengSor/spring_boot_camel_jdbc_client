package com.example.spring_boot_camel_jdbc_client.product;


import com.example.spring_boot_camel_jdbc_client.user.CustomIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor

public class Products {
    private String pro_id;
    private String name;
    private Double price;
    public Products(){
        this.pro_id = CustomIdGenerator.generateCustomId();
    }
}

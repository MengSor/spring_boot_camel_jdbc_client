package com.example.spring_boot_camel_jdbc_client.user.mapper;

import com.example.spring_boot_camel_jdbc_client.product.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserProductDto {
    private Long id;
    private String name;
    private String email;
    private String order;
    List<Products> products = new ArrayList<>();
}

package com.example.spring_boot_camel_jdbc_client.product.mapper;

public record ProductDto(
        Long pro_id,
        Long userid,
        String pro_name,
        Double price
) {
}

package com.example.spring_boot_camel_jdbc_client.product.mapper;

import com.example.spring_boot_camel_jdbc_client.user.CustomIdGenerator;

public record CreateProductDto(
        String pro_id,
        String userid,
        String pro_name,
        Double price
) {
    public CreateProductDto(String pro_id, String userid, String pro_name, Double price) {
//        User user = new User();
//        String users;
//        if (pro_name == user.getName()){
//            userid = user.getId();
//        }
        this.userid = userid;
        this.pro_id = CustomIdGenerator.generateCustomId();
        this.pro_name = pro_name;
        this.price = price;
    }
}

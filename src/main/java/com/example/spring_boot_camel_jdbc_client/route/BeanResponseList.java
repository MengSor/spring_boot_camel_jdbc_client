package com.example.spring_boot_camel_jdbc_client.route;

import lombok.Data;

import java.util.List;

@Data
public class BeanResponseList {
    private List<BeanResponse> responses;
}

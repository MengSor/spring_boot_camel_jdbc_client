package com.example.spring_boot_camel_jdbc_client.user.mapper;

public record UpdateUserDto(
        Long id,
        String name,
        String email
) {
}

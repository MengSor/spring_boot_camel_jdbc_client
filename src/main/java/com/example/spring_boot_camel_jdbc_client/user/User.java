package com.example.spring_boot_camel_jdbc_client.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@Table(name = "users")
public class User {
    private String id;
    private String name;
    private String email;
    public User(){
        this.id = CustomIdGenerator.generateCustomId();
    }
}

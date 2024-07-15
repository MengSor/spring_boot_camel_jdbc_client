package com.example.spring_boot_camel_jdbc_client.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findUserAll();
    Optional<User> findUserById(Long id);
    void saveUser(User user);
}

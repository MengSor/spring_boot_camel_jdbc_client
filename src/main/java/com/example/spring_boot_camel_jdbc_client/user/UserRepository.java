package com.example.spring_boot_camel_jdbc_client.user;

import com.example.spring_boot_camel_jdbc_client.user.mapper.CreateUserDto;
import com.example.spring_boot_camel_jdbc_client.user.mapper.UpdateUserDto;
import com.example.spring_boot_camel_jdbc_client.user.mapper.UserProductDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {

    List<User> findUserAll();
    List<UserProductDto> findAll();
    User findUserById(Long id);
    void saveUser(CreateUserDto userDto);
    void updateUser(UpdateUserDto userDto, Long id);
    void deleteUser(Long id);
}

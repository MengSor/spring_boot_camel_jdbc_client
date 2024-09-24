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
<<<<<<< HEAD
    User findUserById(String id);
    Optional<User> findUserByName(String name);
    void saveUser(User userDto);
    void updateUser(UpdateUserDto userDto, String id);
    void deleteUser(String id);
=======
    User findUserById(Long id);
    void saveUser(CreateUserDto userDto);
    void updateUser(UpdateUserDto userDto, Long id);
    void deleteUser(Long id);
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
}

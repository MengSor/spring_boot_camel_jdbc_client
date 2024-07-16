package com.example.spring_boot_camel_jdbc_client.user;

import com.example.spring_boot_camel_jdbc_client.user.mapper.CreateUserDto;
import com.example.spring_boot_camel_jdbc_client.user.mapper.UpdateUserDto;
import com.example.spring_boot_camel_jdbc_client.user.mapper.UserProductDto;
import com.example.spring_boot_camel_jdbc_client.user.mapper.UserResultExtractor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;


@Service
public class UserService implements UserRepository{

    private final JdbcClient jdbcClient;

    public UserService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<User> findUserAll() {
        return jdbcClient.sql(StatementUser.FIND_USER_ALL.getStatement())
                .query(User.class)
                .list();
    }

    @Override
    public List<UserProductDto> findAll() {
        return jdbcClient.sql(StatementUser.FIND_ALL.getStatement())
                .query(new UserResultExtractor());
    }

    @Override
    public User findUserById(Long id) {
        return jdbcClient.sql(StatementUser.FIND_USER_BY_ID.getStatement())
                .param(id)
                .query(User.class)
                .single();
    }

    @Override
    public void saveUser(CreateUserDto userDto) {
        int save = jdbcClient.sql(StatementUser.CREATE_USER.getStatement())
                .params(List.of(userDto.id(),userDto.name(),userDto.email()))
                .update();
        Assert.state(save == 1 , "Save User" + userDto.name());
    }

    @Override
    public void updateUser(UpdateUserDto userDto, Long id) {
        var update = jdbcClient.sql(StatementUser.UPDATE_USER.getStatement())
                .params(List.of(userDto.name(),userDto.email(),id))
                .update();
        Assert.state(update == 1 , "Update User" + userDto.name());
    }

    @Override
    public void deleteUser(Long id) {
        var delete = jdbcClient.sql(StatementUser.DELETE_USER.getStatement())
                .param(id)
                .update();
        Assert.state(delete == 1 , "Delete User" + id);
    }

}

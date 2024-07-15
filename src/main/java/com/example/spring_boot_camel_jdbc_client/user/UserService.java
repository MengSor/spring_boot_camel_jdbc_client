package com.example.spring_boot_camel_jdbc_client.user;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> findUserById(Long id) {
        return jdbcClient.sql(StatementUser.FIND_USER_BY_ID.getStatement())
                .param(id)
                .query(User.class)
                .optional();
    }

    @Override
    public void saveUser(User user) {

    }
}

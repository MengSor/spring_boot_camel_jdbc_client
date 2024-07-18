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
        return jdbcClient // Accessing the JDBC client
                .sql(StatementUser.FIND_USER_BY_ID.getStatement()) // This method takes a SQL statement and prepares it for execution.
                .param(id)  // This sets the parameter for the SQL query, presumably replacing a placeholder in the SQL statement.
                .query(User.class) // Executes the SQL query and specifies that the result should be mapped to an instance of the User class.
                .single(); // This indicates that only a single result is expected.
    }

    @Override
    public void saveUser(CreateUserDto userDto) {
        int save = jdbcClient
                .sql(StatementUser.CREATE_USER.getStatement())
                .params(List.of(userDto.id(),userDto.name(),userDto.email()))
                .update();
        Assert.state(save == 1 , "Save User" + userDto.name());
    }

    @Override
    public void updateUser(UpdateUserDto userDto, Long id) {
        var update = jdbcClient.sql(StatementUser.UPDATE_USER.getStatement())
                .params(List.of(userDto.name(),userDto.email(),id)) // Parameters to be passed into the SQL statement, extracted from userDto.
                .update(); // Store the result of the update (number of rows affected) in the save variable.

        /*.Use Assert.state to check that save is equal to 1 (i.e., one row was updated).
           .If the assertion fails, throw an IllegalStateException with a message indicating the failure.*/
        Assert.state(update == 1 , "Update User Failed " + userDto.name());
    }

    @Override
    public void deleteUser(Long id) {
        var delete = jdbcClient.sql(StatementUser.DELETE_USER.getStatement())
                .param(id)
                .update();
        Assert.state(delete == 1 , "Delete User" + id);
    }

}

package com.example.spring_boot_camel_jdbc_client.order;

import com.example.spring_boot_camel_jdbc_client.user.StatementUser;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    private final JdbcClient jdbcClient;

    public OrderRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    public List<Order> findOrderAll(){
        return jdbcClient.sql(StatementUser.FIND_ALL_ORDER.getStatement())
                .query(Order.class)
                .list();
    }
    public void saveOrder(Order order) {
        jdbcClient.sql(StatementUser.CREATE_ORDER.getStatement())
                .params(List.of(order.id(), order.buy()))
                .update();
    }
    public void updateOrder(Order order , Long id) {
        jdbcClient.sql(StatementUser.UPDATE_ORDER.getStatement())
                .params(List.of(order.buy(),id))
                .update();
    }
    public void deleteOrder( Long id) {
        jdbcClient.sql(StatementUser.DELETE_ORDER.getStatement())
                .param(id)
                .update();
    }
}

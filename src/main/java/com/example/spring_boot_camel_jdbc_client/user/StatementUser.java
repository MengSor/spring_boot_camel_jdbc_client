package com.example.spring_boot_camel_jdbc_client.user;

public enum StatementUser {
    FIND_USER_ALL("SELECT * FROM users"),
    FIND_USER_BY_ID("SELECT * FROM users WHERE id = ?"),
    FIND_ALL("SELECT users.id,users.name,users.email,products.pro_name,products.price,orders.buy FROM orders,users LEFT JOIN products ON users.id = products.userid WHERE users.id = orders.id"),
    CREATE_USER("INSERT INTO users VALUES (?,?,?)"),
    DELETE_USER("DELETE FROM users WHERE id = ?"),
    UPDATE_USER("UPDATE users SET name = ? , email = ? WHERE id = ?"),
    ID("id");
    private final String statement;

    StatementUser(String statement) {
        this.statement = statement;
    }
    public String getStatement(){
        return statement;
    }
}

package com.example.spring_boot_camel_jdbc_client.user;

public enum StatementUser {
    FIND_USER_ALL("SELECT * FROM users"),
    FIND_USER_BY_ID("SELECT * FROM users WHERE id = ?"),
<<<<<<< HEAD
    FIND_USER_BY_NAME("SELECT * FROM users WHERE name = ?"),
=======
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
    FIND_ALL("SELECT users.id,users.name,users.email,products.pro_name,products.price,orders.buy FROM orders,users LEFT JOIN products ON users.id = products.userid WHERE users.id = orders.id"),
    CREATE_USER("INSERT INTO users VALUES (?,?,?)"),
    DELETE_USER("DELETE FROM users WHERE id = ?"),
    UPDATE_USER("UPDATE users SET name = ? , email = ? WHERE id = ?"),
    ID("id"),
<<<<<<< HEAD

    // SQL Products
    FIND_PROdUCT_ALL("SELECT * FROM products"),
    FIND_PRO_BY_ID("SELECT * FROM products WHERE userid = ?"),
    UPDATE_PRODUCT("UPDATE products SET userid = ? , pro_name = ? , price = ? WHERE pro_id = ?"),
    DELETE_PRODUCT("DELETE FROM products WHERE userid = ?"),
    CREATE_PRODUCT("INSERT INTO products VALUES (?,?,?,?)"),
    // Order
    FIND_ALL_ORDER("SELECT * FROM orders"),
    CREATE_ORDER("INSERT INTO orders VALUES (?,?)"),
    UPDATE_ORDER("UPDATE orders SET buy = ? WHERE id = ?"),
    DELETE_ORDER("DELETE FROM orders WHERE id = ?");
=======
    FIND_PROdUCT_ALL("SELECT * FROM products"),
    CREATE_PRODUCT("INSERT INTO products VALUES (?,?,?,?)");
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
    private final String statement;

    StatementUser(String statement) {
        this.statement = statement;
    }
    public String getStatement(){
        return statement;
    }
}

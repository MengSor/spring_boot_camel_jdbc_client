package com.example.spring_boot_camel_jdbc_client.product.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductMapper implements RowMapper<ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new ProductDto(
                rs.getLong("pro_id"),
                rs.getLong("userid"),
                rs.getString("pro_name"),
                rs.getDouble("price")
        );
    }
}

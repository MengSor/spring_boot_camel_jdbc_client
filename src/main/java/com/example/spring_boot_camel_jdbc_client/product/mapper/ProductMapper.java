package com.example.spring_boot_camel_jdbc_client.product.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductMapper implements RowMapper<ProductDto> {
<<<<<<< HEAD

    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
=======
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {

>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
        return new ProductDto(
                rs.getLong("pro_id"),
                rs.getLong("userid"),
                rs.getString("pro_name"),
<<<<<<< HEAD
                rs.getDouble("price"));
=======
                rs.getDouble("price")
        );
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
    }
}

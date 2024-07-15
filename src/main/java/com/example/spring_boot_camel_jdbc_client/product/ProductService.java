package com.example.spring_boot_camel_jdbc_client.product;

import com.example.spring_boot_camel_jdbc_client.product.mapper.CreateProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.ProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.ProductMapper;
import com.example.spring_boot_camel_jdbc_client.product.mapper.UpdateProductDto;
import com.example.spring_boot_camel_jdbc_client.user.StatementUser;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProductService implements ProductRepository{

    private final JdbcClient jdbcClient;

    public ProductService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<CreateProductDto> finByUserId(Long user_id) {
        return List.of();
    }

    @Override
    public List<ProductDto> findProducts() {
        return jdbcClient
                .sql(StatementUser.FIND_PROdUCT_ALL.getStatement())
                .query(new ProductMapper())
                .list();
    }

    @Override
    public List<CreateProductDto> findById(Long id) {
        return jdbcClient.sql(StatementUser.FIND_PRO_BY_ID.getStatement())
                .param(id)
                .query(CreateProductDto.class)
                .list();
    }

    @Override
    public void saveProduct(CreateProductDto productDto) {
        int save = jdbcClient
                .sql(StatementUser.CREATE_PRODUCT.getStatement())
                .params(List.of(productDto.pro_id(),productDto.userid(),productDto.pro_name(),productDto.price()))
                .update();
        Assert.state(save == 1 , "Save Product" + productDto.pro_name());
    }

    @Override
    public void updateProduct(UpdateProductDto productDto, Long id) {
       jdbcClient.sql(StatementUser.UPDATE_PRODUCT.getStatement())
               .params(List.of(productDto.userid(),productDto.pro_name(),productDto.price(),id))
               .update();
    }

    @Override
    public void deleteProduct(Long id) {
        jdbcClient.sql(StatementUser.DELETE_PRODUCT.getStatement())
                .param(id)
                .update();
    }
}

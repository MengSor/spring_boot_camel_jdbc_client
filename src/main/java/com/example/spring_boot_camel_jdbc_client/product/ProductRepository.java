package com.example.spring_boot_camel_jdbc_client.product;

import com.example.spring_boot_camel_jdbc_client.product.mapper.CreateProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.ProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.UpdateProductDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    @Query(value = "SELECT * FROM products p where p.userid = ?1")
    List<CreateProductDto> finByUserId(Long userid);

    List<ProductDto> findProducts();
    List<CreateProductDto> findById(Long id);
    void saveProduct(CreateProductDto productDto);
    void updateProduct(UpdateProductDto productDto , Long id);
    void deleteProduct(Long id);

}

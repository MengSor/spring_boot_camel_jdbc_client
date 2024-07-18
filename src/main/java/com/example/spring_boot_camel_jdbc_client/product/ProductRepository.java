package com.example.spring_boot_camel_jdbc_client.product;

import com.example.spring_boot_camel_jdbc_client.product.mapper.CreateProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.ProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.UpdateProductDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    List<ProductDto> findProducts();
    void saveProduct(CreateProductDto productDto);
    void updateProduct(UpdateProductDto productDto , Long id);
    void deleteProduct(Long id);
}

package com.example.spring_boot_camel_jdbc_client.product;

import com.example.spring_boot_camel_jdbc_client.product.mapper.CreateProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.ProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.UpdateProductDto;
<<<<<<< HEAD
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
=======
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

<<<<<<< HEAD
    @Query(value = "SELECT * FROM products p where p.userid = ?1")
    List<CreateProductDto> finByUserId(Long userid);

    List<ProductDto> findProducts();
    List<CreateProductDto> findById(Long id);
    void saveProduct(CreateProductDto productDto);
    void updateProduct(UpdateProductDto productDto , Long id);
    void deleteProduct(Long id);

=======
    List<ProductDto> findProducts();
    void saveProduct(CreateProductDto productDto);
    void updateProduct(UpdateProductDto productDto , Long id);
    void deleteProduct(Long id);
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
}

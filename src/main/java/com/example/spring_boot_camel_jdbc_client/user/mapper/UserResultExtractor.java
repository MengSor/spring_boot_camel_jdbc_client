package com.example.spring_boot_camel_jdbc_client.user.mapper;

import com.example.spring_boot_camel_jdbc_client.product.Products;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.*;

/*Your UserResultExtractor class implements ResultSetExtractor to convert a ResultSet into a list of UserProductDto objects.*/
=======
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

 /*Your UserResultExtractor class implements ResultSetExtractor to convert a ResultSet into a list of UserProductDto objects.*/
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a

public class UserResultExtractor implements ResultSetExtractor<List<UserProductDto>> {
    @Override
    public List<UserProductDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
<<<<<<< HEAD
        Map<Long,UserProductDto> userProducts = new HashMap<>();
=======
        Map<Long,UserProductDto> userProducts = new LinkedHashMap<>();
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
        UserProductDto userProductDto = null;
        while (rs.next()){
            Long Id = rs.getLong("id");
            userProductDto = userProducts.get(Id);
            if (userProductDto == null) {
                userProductDto = new UserProductDto();
                userProductDto.setId(Id);
<<<<<<< HEAD
                userProductDto.setName("random");
=======
                userProductDto.setName(rs.getString("name"));
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
                userProductDto.setEmail(rs.getString("email"));
                userProductDto.setOrder(rs.getString("buy"));
                userProducts.put(Id,userProductDto);
            }
            Products products = new Products();
            products.setName(rs.getString("pro_name"));
            products.setPrice(rs.getDouble("price"));
            userProductDto.getProducts().add(products);
        }
        return new ArrayList<>(userProducts.values()); // Convert userProducts.values() to a List<UserProductDto> Return the list
    }
}

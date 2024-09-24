package com.example.spring_boot_camel_jdbc_client.route;

import com.example.spring_boot_camel_jdbc_client.product.ProductRepository;
import com.example.spring_boot_camel_jdbc_client.product.Products;
import com.example.spring_boot_camel_jdbc_client.product.mapper.CreateProductDto;
import com.example.spring_boot_camel_jdbc_client.user.User;
import com.example.spring_boot_camel_jdbc_client.user.UserRepository;
import org.apache.camel.LoggingLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component("metaDataProcessor")
public class MetaDataProcessor {
    private static final Logger logger = LoggerFactory.getLogger(MetaDataProcessor.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public BeanResponseList deleteUsers(String id) {
//        UserProductDto user = exchange.getIn().getBody(UserProductDto.class);
        User user;
        BeanResponseList beanResponses = new BeanResponseList();
        List<BeanResponse> beanResponseList = new ArrayList<>();
//        for() {
            BeanResponse beanResponse = null;
            try {
               Optional<User> users = Optional.ofNullable(userRepository.findUserById(id));
                getUser(Arrays.asList(users.get()));
                beanResponse = BeanResponse.builder().success(true).massage("success").code(HttpStatus.OK.value()).data(users).build();
                logger.info("Body content ###: {}", beanResponse);

            } catch (Exception e) {
                beanResponse = BeanResponse.builder().massage("Error").success(true).code(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
                logger.info("Error : {}", beanResponse,e);
            }
            beanResponseList.add(beanResponse);
//        }
       beanResponses.setResponses(beanResponseList);
       return beanResponses;
    }

    public BeanResponse<?> getAllUsers(){
//        logger.info("Fetching all users from the database");
        List<User> users = userRepository.findUserAll();
        BeanResponse<?> response;
        if(!users.isEmpty()){
//            logger.info("User cache table process successfully");
//            deleteProducts(Arrays.asList());
            response = BeanResponse.builder().data(users).massage("success").success(true).code(HttpStatus.OK.value()).build();
            logger.info("Body content ##: {}", response);
            logger.info("Interface configuration updated successfully");
        }else {
            return BeanResponse.builder().success(false).massage("Error").code(HttpStatus.NOT_FOUND.value()).build();
        }
        return response;
    }
    private void getUser(List<User> users) {
        for (User user : users) {
//            deleteProduct(productRepository.findProducts(user.getId()));
//            deleteProducts(productRepository.findById(user.getId()));
            userRepository.deleteUser(user.getId());
        }
    }
//    private void deleteProducts(List<CreateProductDto> productDtos) {
//        logger.info("{}",productDtos);
//        for (CreateProductDto productDto : productDtos){
//            productRepository.deleteProduct(productDto.userid());
//        }
//    }

    public void deleteDetail(List<User> users){
       for (User user : users) {
           try {
               userRepository.deleteUser(user.getId());
           } catch (Exception e) {
               throw new RuntimeException("Error while deleting ");
           }
       }
    }
}

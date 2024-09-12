package com.example.spring_boot_camel_jdbc_client.route;

import com.example.spring_boot_camel_jdbc_client.user.User;
import com.example.spring_boot_camel_jdbc_client.user.UserService;
import com.example.spring_boot_camel_jdbc_client.user.mapper.CreateUserDto;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("controller")
@RequestMapping("/api")
@Validated
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private MetaDataProcessor metaDataProcessor;
    @Autowired
    private UserService service;
    @DeleteMapping("/v1/{id}")
    public ResponseEntity<BeanResponseList> getUserAll(@PathVariable String id) {
//        logger.info("Successfully retrieved {} users");
        BeanResponseList agentResponses = metaDataProcessor.deleteUsers(id);
        logger.info("Salesforce cache table process successfully");
        return ResponseEntity.ok(agentResponses);
    }

    @GetMapping("/v1")
    public ResponseEntity<BeanResponse> getUserAll() {
//        logger.info("Successfully retrieved {} users");
        BeanResponse agentResponses = metaDataProcessor.getAllUsers();
        logger.info("Salesforce table process successfully");
        return ResponseEntity.ok(agentResponses);
    }
    @GetMapping("/v1/v2")
    public List<User> findUserAll(){
        return service.findUserAll();
    }
    @PostMapping("/v1")
    public ResponseEntity<String> saveUser(@RequestBody User createUserDto){
        Optional<User> user = service.findUserByName(createUserDto.getName());
            if (user.isPresent()) {
                logger.info("User already exists");
                return new ResponseEntity<>("User with the same name already exists.", HttpStatus.BAD_REQUEST);
            }else {

                  service.saveUser(createUserDto);
                logger.info("User saved successfully");
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
    }
    @PostMapping
    public void save(@RequestBody User user){
        service.saveUser(user);
    }

    @GetMapping("/{name}")
    public Optional<User> findByName(@PathVariable String name){
        return service.findUserByName(name);
    }
}

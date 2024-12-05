package com.example.spring_boot_camel_jdbc_client.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerUser {

    private static final Logger log = LoggerFactory.getLogger(ControllerUser.class);

    @GetMapping("/go")
    public String getUserName() {
        log.info("getUserName");
        return "hello";
    }
}

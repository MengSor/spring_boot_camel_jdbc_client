package com.example.spring_boot_camel_jdbc_client.route;

import com.example.spring_boot_camel_jdbc_client.user.UserService;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class ControllerRest {
    private static final Logger log = LoggerFactory.getLogger(ControllerRest.class);
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public void get (Exchange exchange) {
        userService.findUserAll(exchange);
        log.info("userRoute.findUserAll");
    }
}

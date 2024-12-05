package com.example.spring_boot_camel_jdbc_client;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCamelJdbcClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCamelJdbcClientApplication.class, args);
    }

//    @Bean
//    public ServletRegistrationBean<CamelHttpTransportServlet> customCamelServletRegistrationBean() {
//        ServletRegistrationBean<CamelHttpTransportServlet> registration = new ServletRegistrationBean<CamelHttpTransportServlet>(new CamelHttpTransportServlet(), "/*");
//        registration.setName("CamelServlet");
//        return registration;
//    }

//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
//        return factory -> factory.setContextPath("/application/*");
//    }
}

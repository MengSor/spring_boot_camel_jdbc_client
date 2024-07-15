package com.example.spring_boot_camel_jdbc_client.route;

import com.example.spring_boot_camel_jdbc_client.user.UserRepository;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {
    private final Environment env;

    public UserRoute(Environment env) {
        this.env = env;
    }

    @Override
    public void configure() throws Exception {
        // REST Configuration
        restConfiguration()
                .contextPath(env.getProperty("camel.component.servlet.mapping.contextPath", "/api/*"))
//                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Customer API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .port(env.getProperty("server.port" , "8080"))
                .bindingMode(RestBindingMode.json);

        rest("/users")
                .get("/")
                .to("direct:findUserAll");

        from("direct:findUserAll")
                .bean(UserRepository.class , "findUserAll");

    }
}

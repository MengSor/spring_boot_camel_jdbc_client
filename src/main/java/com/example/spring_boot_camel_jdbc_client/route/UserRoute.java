package com.example.spring_boot_camel_jdbc_client.route;


import com.example.spring_boot_camel_jdbc_client.user.UserRepository;
import com.example.spring_boot_camel_jdbc_client.user.mapper.CreateUserDto;
import com.example.spring_boot_camel_jdbc_client.user.mapper.UpdateUserDto;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {
    private final Environment env;

    public UserRoute(Environment env) {
        this.env = env;
    }

    @Override
    public void configure() throws Exception {

        /*Your onException block in Apache Camel is designed to catch exceptions, log an error message,
        and return a JSON response with a 404 status code. */

        // Global exception handling
        onException(Exception.class) // This defines the type of exception to be caught and handled.
                .log("Error occurred: ${exception.message}") // logs the message.
                .handled(true) // The exception is marked as handled
                .setHeader("Content-Type", constant("application/json")) //Sets the Content-Type header to application/json.
                .setBody(simple("{\"error\": \"${exception.message}\"}")) //Sets the body of the response to a JSON string containing the error message.
                .setHeader("CamelHttpResponseCode", constant(404)); //Sets the HTTP response code to 404.

        // REST Configuration
        restConfiguration()
                .contextPath(env.getProperty("camel.servlet.mapping.context-path", "/rest/*"))
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Customer API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .port(env.getProperty("server.port" , "8090"))
                .bindingMode(RestBindingMode.json);

        // REST Endpoints
        rest("/users")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .get("/")
                .to("direct:findUserAll")
                .get("/all")
                .to("direct:findAll")
                .get("/{id}")
                .to("direct:findUserById")
                .post("/")
                .to("direct:saveUser")
                .put("/{id}")
                .to("direct:updateUser")
                .delete("/{id}")
                .to("direct:deleteUser");

        // Route Definitions
        from("direct:findUserAll")
                .log("Fetching all users")
                .bean(UserRepository.class , "findUserAll")
                .log("Fetched all users successfully")
                .to("log:output");

       from("direct:findAll")
               .bean(UserRepository.class , "findAll")
               .log("Fetched all successfully")
               .to("log:output");

        from("direct:findUserById")
                .log("Received header: ${header.id}")
                .bean(UserRepository.class , "findUserById(${header.id})")
                .log("Fetched User with id ${header.id} successfully");

        from("direct:saveUser")
                .log("Received body: ${body}")
                .marshal().json()
                .unmarshal().json(CreateUserDto.class)
                .bean(UserRepository.class , "saveUser(${body})")
                .log("Created a new user successfully");

        from("direct:updateUser")
                .log("Received header: ${body},${header.id}")
                .marshal().json()
                .unmarshal().json(UpdateUserDto.class)
                .bean(UserRepository.class , "updateUser(${body},${header.id})")
                .log("Updated user with id ${header.id} successfully");

        from("direct:deleteUser")
                .log("Received header: ${header.id}")
                .bean(UserRepository.class , "deleteUser(${header.id})")
                .log("Deleted user with id ${header.id} successfully");

    }
}

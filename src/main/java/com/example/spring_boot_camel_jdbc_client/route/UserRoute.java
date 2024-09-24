package com.example.spring_boot_camel_jdbc_client.route;

<<<<<<< HEAD
/*
   We configure the restConfiguration to use the servlet component.
   We define a REST endpoint /api/hello that directs to a route direct:hello.
   The route direct:hello simply sets the body of the response to "Hello, World!"
 */

import com.example.spring_boot_camel_jdbc_client.order.Order;
import com.example.spring_boot_camel_jdbc_client.order.OrderRepository;
import com.example.spring_boot_camel_jdbc_client.product.ProductRepository;
import com.example.spring_boot_camel_jdbc_client.product.mapper.CreateProductDto;
import com.example.spring_boot_camel_jdbc_client.product.mapper.UpdateProductDto;
import com.example.spring_boot_camel_jdbc_client.user.User;
import com.example.spring_boot_camel_jdbc_client.user.UserRepository;
import com.example.spring_boot_camel_jdbc_client.user.mapper.CreateUserDto;
import com.example.spring_boot_camel_jdbc_client.user.mapper.UpdateUserDto;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
=======

import com.example.spring_boot_camel_jdbc_client.product.ProductRepository;
import com.example.spring_boot_camel_jdbc_client.product.Products;
import com.example.spring_boot_camel_jdbc_client.product.mapper.CreateProductDto;
import com.example.spring_boot_camel_jdbc_client.user.UserRepository;
import com.example.spring_boot_camel_jdbc_client.user.mapper.CreateUserDto;
import com.example.spring_boot_camel_jdbc_client.user.mapper.UpdateUserDto;
import net.sf.jsqlparser.statement.create.procedure.CreateProcedure;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.core.env.Environment;
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {

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

<<<<<<< HEAD
//        onException(Exception.class)
//                .log("This is error message: ${exception}");
        //    OpenAPI
        OpenAPI openAPI = new OpenAPI();
        Info info = new Info()
                .title("My API")
                .version("1.0.0")
                .description("This is my API");
        openAPI.info(info);

        // REST Configuration
        restConfiguration()
                .component("servlet")
                .contextPath("/rest")
                .apiContextPath("/api-docs")
                .apiContextRouteId("api-docs")
                .apiProperty("api.title", "My API")
                .apiProperty("api.version", "1.0")
                .apiProperty("base.path", "/api")
                .apiProperty("cors", "true")
                .apiProperty("openapi", openAPI.toString())
=======
        // REST Configuration
        restConfiguration()
                .component("servlet")
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
                .bindingMode(RestBindingMode.json);

        // REST Endpoints
        rest("/users")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .get("/")
<<<<<<< HEAD
                .routeId("Get")
                .description("Returns a greeting message")
                .outType(User.class)
=======
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
                .to("direct:findUserAll")
                .get("/all")
                .to("direct:findAll")
                .get("/{id}")
<<<<<<< HEAD
                .routeId("Get By ID")
                .description("Returns By ID a greeting message")
                .outType(String.class)
                .to("direct:findUserById")
                .post("/")
                .routeId("Post")
                .description("Input a greeting message")
                .outType(Integer.class)
=======
                .to("direct:findUserById")
                .post("/")
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
                .to("direct:saveUser")
                .put("/{id}")
                .to("direct:updateUser")
                .delete("/{id}")
                .to("direct:deleteUser")
<<<<<<< HEAD
                //  Get Products
                .get("/products")
                .to("direct:findProducts")
                .get("/products/{id}")
                .to("direct:findById")
                .post("/products")
                .to("direct:saveProduct")
                .patch("/products/{id}")
                .to("direct:updateProduct")
                .delete("/products/{id}")
                .to("direct:deleteProduct")
                 // Orders
                .get("/orders")
                .to("direct:findOrderAll")
                .post("/orders")
                .to("direct:saveOrder")
                .put("/orders/{id}")
                .to("direct:updateOrder")
                .delete("/orders/{id}")
                .to("direct:deleteOrder");
=======
//                Get Products
                .get("/products")
                .to("direct:findProducts")
                .post("/products")
                .to("direct:saveProduct");
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a


        // Route Definitions
        from("direct:findUserAll")
<<<<<<< HEAD
//                .onCompletion()
                .log( "Fetching all users")
=======
                .log("Fetching all users")
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
                .bean(UserRepository.class , "findUserAll")
                .log("Fetched all users successfully")
                .to("log:output");

<<<<<<< HEAD
//       from("direct:findAll")
////               .bean(UserRepository.class , "findAll")
//               .log("Fetched all successfully")
//               .to("controller","findUserAll");

        from("direct:findUserById")
//                .log("Received header: ${header.id}")
//                .bean(UserRepository.class , "findUserById(${header.id})")
//                .log("Fetched User with id ${header.id} successfully")
//                .to("log:output")
                .doTry()
                .log("Received: ${header.id}")
                .bean(UserRepository.class , "findUserById(${header.id})")
                .doCatch(Exception.class)
                .log("Error: ${exception.message}")
                .to("jms:queue:errorQueue")
                .doFinally()
                .log("Successfully");
=======
       from("direct:findAll")
               .bean(UserRepository.class , "findAll")
               .log("Fetched all successfully")
               .to("log:output");

        from("direct:findUserById")
                .log("Received header: ${header.id}")
                .bean(UserRepository.class , "findUserById(${header.id})")
                .log("Fetched User with id ${header.id} successfully")
                .to("log:output");
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a

        from("direct:saveUser")
                .log("Received body: ${body}")
                .marshal().json()
<<<<<<< HEAD
                .unmarshal().json(User.class)
=======
                .unmarshal().json(CreateUserDto.class)
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
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
<<<<<<< HEAD
                .bean(UserController.class , "getUserAll(${header.id})")
                .log("Deleted user with id ${header.id} successfully");

        //  Get Products
        from("direct:findProducts")
                .bean(ProductRepository.class , "findProducts");

        from("direct:findById")
                .bean(ProductRepository.class , "findById(${header.id})");

=======
                .bean(UserRepository.class , "deleteUser(${header.id})")
                .log("Deleted user with id ${header.id} successfully");

        from("direct:findProducts")
                .bean(ProductRepository.class , "findProducts");

>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
        from("direct:saveProduct")
                .log("Received body: ${body}")
                .marshal().json()
                .unmarshal().json(CreateProductDto.class)
                .bean(ProductRepository.class , "saveProduct(${body})")
                .log("Created a new user successfully");
<<<<<<< HEAD

        from("direct:updateProduct")
                .log("Received header: ${body}, ${header.id}")
                .marshal().json()
                .unmarshal().json(UpdateProductDto.class)
                .bean(ProductRepository.class , "updateProduct(${body}, ${header.id})")
                .log("Updated product with id ${header.id} successfully");

        from("direct:deleteProduct")
                .log("Received header : ${header.id}")
                .bean(ProductRepository.class , "deleteProduct(${header.id})")
                .log("Deleted product with id ${header.id} successfully");

        // Orders
        from("direct:findOrderAll")
                .bean(OrderRepository.class , "findOrderAll");

        from("direct:saveOrder")
                .log("Received body: ${body}")
                .marshal().json()
                .unmarshal().json(Order.class)
                .bean(OrderRepository.class , "saveOrder(${body})");

        from("direct:updateOrder")
                .log("Received body: ${body},${header.id}")
                .marshal().json()
                .unmarshal().json(Order.class)
                .bean(OrderRepository.class , "updateOrder(${body},${header.id})");

        from("direct:deleteOrder")
                .log("Received header : ${header.id}")
                .bean(OrderRepository.class , "deleteOrder(${header.id})");
=======
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a

    }
}
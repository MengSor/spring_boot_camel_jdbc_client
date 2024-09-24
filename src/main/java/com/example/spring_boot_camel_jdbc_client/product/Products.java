package com.example.spring_boot_camel_jdbc_client.product;


<<<<<<< HEAD
import com.example.spring_boot_camel_jdbc_client.user.CustomIdGenerator;
=======
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
<<<<<<< HEAD
//@NoArgsConstructor

public class Products {
    private String pro_id;
    private String name;
    private Double price;
    public Products(){
        this.pro_id = CustomIdGenerator.generateCustomId();
    }
=======
@NoArgsConstructor

public class Products {
    private String name;
    private Double price;
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
}

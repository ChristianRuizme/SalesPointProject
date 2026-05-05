package com.example.salespointproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class SalesPointProjectApplication {

    public static void main(String[] args) {

        //Cargo mis variables de entorno
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        //Vanilla
        SpringApplication.run(SalesPointProjectApplication.class, args);
    }
}

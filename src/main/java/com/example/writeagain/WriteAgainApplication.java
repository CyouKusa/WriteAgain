package com.example.writeagain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class WriteAgainApplication {
    @Bean("multipartResolver")
    public static void main(String[] args) {
        SpringApplication.run(WriteAgainApplication.class, args);
    }

}

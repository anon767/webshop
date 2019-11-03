package com.hska.webshop.category_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@SpringBootApplication
@Configuration
public class CategoryCoreApplication extends ResourceServerConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(CategoryCoreApplication.class, args);
    }


}

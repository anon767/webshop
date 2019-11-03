package com.hska.webshop.category_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@SpringBootApplication
public class CategoryCoreApplication extends ResourceServerConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(CategoryCoreApplication.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated();
    }
}

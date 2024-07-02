package com.example.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Butun URl-lere icaze ver
                .allowedOrigins("*") // Butun originlere icaze ver
                .allowedMethods("GET", "POST", "PUT", "DELETE","HEAD","OPTIONS") // Istediyin metodlar
                .allowedHeaders("*"); // Butun head-lere icaze ver
    }
}


package com.example.EduBox_Backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("https://edubox-one.vercel.app","https://edu-box-hod-puce.vercel.app", "http://localhost:3000") // Use patterns instead of "*"
                        .allowedMethods("*") // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow credentials (cookies, HTTP auth)
            }
        };
    }
}

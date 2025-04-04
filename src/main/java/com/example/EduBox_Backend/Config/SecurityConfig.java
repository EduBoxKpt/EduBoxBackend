package com.example.EduBox_Backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
            		 .requestMatchers("/api/**").permitAll() // Allows all endpoints under /api
                .anyRequest().authenticated() // Secure other endpoints
            )
            .httpBasic(Customizer.withDefaults()) // Use HTTP Basic Authentication if needed
            .formLogin(AbstractHttpConfigurer::disable); // Disable Form Login (for APIs)

        return http.build();
    }
}

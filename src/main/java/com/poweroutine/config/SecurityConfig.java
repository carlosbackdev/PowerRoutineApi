package com.poweroutine.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Desactiva CSRF
                .authorizeHttpRequests() // Cambié de authorizeRequests() a authorizeHttpRequests()
                .requestMatchers("/**").permitAll()  // Permite acceso sin autenticación a todos los endpoints
                .anyRequest().permitAll();  // Permite cualquier otra solicitud sin autenticación
        return http.build();
    }
}
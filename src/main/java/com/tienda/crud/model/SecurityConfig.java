package com.tienda.crud.model;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ nuevo formato
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/uploads/**", "/api/clientes", "/api/clientes/**").permitAll() // imágenes y registro públicos
                        .anyRequest().permitAll() // TODO está público por ahora (para desarrollo)
                );
        return http.build();
    }
}

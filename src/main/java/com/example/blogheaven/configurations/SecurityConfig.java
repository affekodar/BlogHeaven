package com.example.blogheaven.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/posts").permitAll()
                        .requestMatchers("/api/posts/{id}").permitAll()
                        .requestMatchers("/api/newuser").permitAll()
                        .requestMatchers("/api/newpost").hasRole("client_user")
                        .requestMatchers("/api/updatepost/{id}").hasRole("client_user")
                        .requestMatchers("/api/deletepost/{id}").hasRole("client_user")
                        .requestMatchers("/api/users").hasRole("client_admin")
                        .requestMatchers("/api/users/{id}").hasRole("client_admin")
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .oauth2ResourceServer(oauth2ResourceServer ->
                        oauth2ResourceServer
                                .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter))
                );


        return http.build();
    }
}

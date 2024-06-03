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
/*                        .requestMatchers("/api/posts").permitAll()
                        .requestMatchers("/api/posts{id}").permitAll()
                        .requestMatchers("/api/newpost").hasRole("USER")
                        .requestMatchers("/api/updatepost/{id}").hasRole("USER")
                        .requestMatchers("/api/deletepost/{id}").hasRole("USER")*/
/*
                        .requestMatchers("/api/users").hasRole("client_admin")
*/
                        /*.requestMatchers("/api/users/{id}").hasRole("ADMIN")*/
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

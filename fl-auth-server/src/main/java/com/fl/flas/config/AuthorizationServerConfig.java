package com.fl.flas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthorizationServerConfig {
    @Bean
    public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/oauth2/**", "/actuator/**")
                .permitAll()
                .anyRequest()
                .authenticated())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/oauth2/**"))
                        .formLogin(Customizer.withDefaults())
                        .oauth2ResourceServer(oauth2 -> oauth2
                                .jwt(Customizer.withDefaults()));
        return http.build();
    }
}

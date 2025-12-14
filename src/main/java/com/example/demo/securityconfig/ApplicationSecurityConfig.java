package com.example.demo.securityconfig;

import static org.springframework.security.config.Customizer.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    // @Bean
    // public WebSecurityCustomizer webSecurityCustomizer() {
    // // The .ignoring() method ensures that the request for this exact path
    // // will bypass the entire filter chain, preventing any login challenges.
    // return (web) -> web.ignoring().requestMatchers("/api/users");
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.
        // authentication and authorization configuration
                authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                // form login configuration
                .formLogin(form -> form
                        .defaultSuccessUrl("/api/home", true)
                        .permitAll())
                // HTTP Basic authentication configuration
                .httpBasic(withDefaults())
                .build();
    }
}

package com.example.demo.securityconfig;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailService {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {

        org.springframework.security.core.userdetails.UserDetails user1 = org.springframework.security.core.userdetails.User
                .builder()
                .username("praveen")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN, USER")
                .build();

        org.springframework.security.core.userdetails.UserDetails user2 = org.springframework.security.core.userdetails.User
                .builder()
                .username("rolex")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    };
}

package com.example.spring_security_exe.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomInMemoryUserDetilsManager extends InMemoryUserDetailsManager {

    public CustomInMemoryUserDetilsManager() {
        User.UserBuilder userBuilder = User.builder();
        UserDetails admin = userBuilder.username("admin").password("{noop}admin").roles("ADMIN").build();
        UserDetails user = userBuilder.username("user").password("{noop}user").roles("USER").build();
        createUser(admin);
        createUser(user);
    }


}

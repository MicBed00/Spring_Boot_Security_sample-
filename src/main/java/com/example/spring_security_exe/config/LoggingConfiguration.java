package com.example.spring_security_exe.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LoggingConfiguration {

    /*
     wprowadzenie przekierowania na własny endpoint ze stroną logowania. Bez tej implementacji wyświetli się
     standardowy widok zwracany przez filtr DefaultLoginPageGeneratingFilter.

      http.formLogin(login -> login.loginPage("/login").permitAll()); - przekierownaie do endpoint  @GetMapping(value = "/login")
      który zwraca stworzony widok strony logowania
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.csrf().disable();
        return http.build();
    }

    /*
    Pierwszy sposób: dodanie domyślnych użytkowników. W tym rozwiązaniu użytkownicy są zapisywani do HashMap w klasie InMemoryUserDetailsManager()
    Drugi sposób: stowrzenie klasy rozszerzającej InMemoryUserDetails i w konstrukotrze tej klasy zaimplementować dodawanie użytkownikó
     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        User.UserBuilder userBuilder = User.builder();
//        UserDetails admin = userBuilder.username("admin").password("{noop}admin").roles("ADMIN").build();
//        UserDetails user = userBuilder.username("user").password("{noop}user").roles("USER").build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }
}

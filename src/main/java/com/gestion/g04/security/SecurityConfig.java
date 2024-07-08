package com.gestion.g04.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
           httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/webjar/**").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/updateProduct","/deleteProduct","/showProduct").hasAnyRole("ADMIN");

        httpSecurity.authorizeHttpRequests().requestMatchers("/createProduct","/saveProduct").hasAnyRole("ADMIN","CASHIER");

        httpSecurity.authorizeHttpRequests().requestMatchers("/productsList").hasAnyRole("ADMIN","CASHIER","USER");
           httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
           httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");
           return httpSecurity.build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN","USER").build(),
                User.withUsername("cashier").password(passwordEncoder.encode("123")).roles("CASHIER").build(),
                User.withUsername("accountant").password(passwordEncoder.encode("123")).roles("USER").build());
    }
}

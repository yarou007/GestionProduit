package com.gestion.g04.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
           httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();

        httpSecurity.authorizeHttpRequests().requestMatchers("/webjar/**").permitAll();

        httpSecurity.rememberMe();
        httpSecurity.authorizeHttpRequests().requestMatchers("/updateProduct","/deleteProduct","/showProduct").hasAuthority("ROLE_ADMIN");

        httpSecurity.authorizeHttpRequests().requestMatchers("/createProduct","/saveProduct").hasAnyAuthority("ROLE_ADMIN","ROLE_CASHIER");

        httpSecurity.authorizeHttpRequests().requestMatchers("/productsList").hasAnyAuthority("ROLE_ADMIN","ROLE_CASHIER","ROLE_USER");
           httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
           httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");
           return httpSecurity.build();
    }
    //@Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//
//        return new InMemoryUserDetailsManager(
//                User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN","USER").build(),
//                User.withUsername("cashier").password(passwordEncoder.encode("123")).roles("CASHIER").build(),
//                User.withUsername("accountant").password(passwordEncoder.encode("123")).roles("USER").build());
//    }

    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource datasource){
        return new JdbcUserDetailsManager(datasource);
    }
}

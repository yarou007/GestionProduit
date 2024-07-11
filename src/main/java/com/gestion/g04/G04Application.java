package com.gestion.g04;

import com.gestion.g04.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class G04Application {

    public static void main(String[] args) {
        SpringApplication.run(G04Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountService accountService) {
        return args -> {
              System.out.println(         accountService.loadUserByUsername("cashier").getEmail());
        };
    }
}

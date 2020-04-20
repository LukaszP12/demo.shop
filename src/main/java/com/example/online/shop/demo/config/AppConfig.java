package com.example.online.shop.demo.config;

import com.example.online.shop.demo.model.dao.Role;
import com.example.online.shop.demo.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
        return args -> {
            Optional<Role> roleUser = roleRepository.findByName("ROLE_USER");
            if (roleUser.isEmpty()){
               roleRepository.save(new Role(null,"ROLE_USER"));
            }
            Optional<Role> roleAdmin = roleRepository.findByName("ROLE_ADMIN");
            if (roleAdmin.isEmpty()){
                roleRepository.save(Role.builder()
                    .name("ROLE_ADMIN")
                    .build()
                );
            }

        };
    }

}

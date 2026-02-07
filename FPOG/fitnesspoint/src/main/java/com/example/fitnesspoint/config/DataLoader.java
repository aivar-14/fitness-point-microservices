package com.example.fitnesspoint.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.fitnesspoint.model.User;
import com.example.fitnesspoint.repository.UserRepository;

@Configuration
public class DataLoader {

    @Bean
    @SuppressWarnings("unused")
    CommandLineRunner init(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("Created admin/admin123");
            }
        };
    }
}

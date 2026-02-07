// package com.example.fitnesspoint.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import com.example.fitnesspoint.service.CustomUserDetailsService;

// @Configuration
// @EnableMethodSecurity
// public class SecurityConfig {

//     private final CustomUserDetailsService userDetailsService;

//     public SecurityConfig(CustomUserDetailsService uds) {
//         this.userDetailsService = uds;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/css/**", "/js/**", "/images/**", "/assets/**", "/signup", "/login", "/")
//                         .permitAll()
//                         .anyRequest().authenticated())
//                 .formLogin(form -> form
//                         .loginPage("/login")
//                         .defaultSuccessUrl("/", true)
//                         .permitAll())
//                 .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/"))
//                 .userDetailsService(userDetailsService)
//                 .csrf(csrf -> csrf.disable());
//         return http.build();
//     }

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
package com.example.fitnesspoint.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.fitnesspoint.security.JwtRequestFilter;
import com.example.fitnesspoint.service.CustomUserDetailsService;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/", "/index", "/css/**", "/js/**", "/assets/**", "/images/**", "/signup", "/login",
                        "/register", "/h2-console/**", "/api/auth/login")
                .permitAll()
                .requestMatchers("/bmi/**", "/bmi", "/bmi.html", "/workout", "/workout.html", "/dietplan",
                        "/dietplan.html",
                        "/diet", "/api/**")
                .authenticated()
                .anyRequest().permitAll())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/"))
                .userDetailsService(userDetailsService)
                .csrf(csrf -> csrf.disable());

        // Add JWT filter only for API endpoints
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        // allow H2 console frames (if you use H2 during dev)
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

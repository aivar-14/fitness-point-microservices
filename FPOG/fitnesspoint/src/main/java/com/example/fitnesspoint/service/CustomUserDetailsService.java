// package com.example.fitnesspoint.service;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.example.fitnesspoint.model.User;
// import com.example.fitnesspoint.repository.UserRepository;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final UserRepository userRepo;

//     public CustomUserDetailsService(UserRepository userRepo) {
//         this.userRepo = userRepo;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User u = userRepo.findByUsername(username)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//         return org.springframework.security.core.userdetails.User.withUsername(u.getUsername())
//                 .password(u.getPassword())
//                 .roles(u.getRole().replace("ROLE_",""))
//                 .build();
//     }
// }
package com.example.fitnesspoint.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.fitnesspoint.model.User;
import com.example.fitnesspoint.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return org.springframework.security.core.userdetails.User.withUsername(u.getUsername())
                .password(u.getPassword())
                .roles(u.getRole().replace("ROLE_", ""))
                .build();
    }
}

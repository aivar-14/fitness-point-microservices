// package com.example.fitnesspoint.controller;

// import org.springframework.dao.DataIntegrityViolationException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.example.fitnesspoint.model.User;
// import com.example.fitnesspoint.repository.UserRepository;

// @Controller
// public class AuthController {
//     private final UserRepository userRepo;
//     private final BCryptPasswordEncoder passwordEncoder;

//     public AuthController(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
//         this.userRepo = userRepo;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @GetMapping("/signup")
//     public String signupForm(Model m, @RequestParam(value = "error", required = false) String error) {
//         m.addAttribute("user", new User());
//         if (error != null) {
//             m.addAttribute("signupError", error);
//         }
//         return "login";
//     }

//     @PostMapping("/signup")
//     public String signupSubmit(@ModelAttribute User user, Model m) {
//         try {
//             user.setPassword(passwordEncoder.encode(user.getPassword()));
//             user.setRole("ROLE_USER");
//             userRepo.save(user);
//             return "redirect:/login?signupSuccess";
//         } catch (DataIntegrityViolationException e) {
//             m.addAttribute("signupError", "Username already exists. Please choose another.");
//             m.addAttribute("user", user);
//             return "login";
//         }
//     }

//     @GetMapping("/login")
//     public String login(@RequestParam(value = "error", required = false) String error,
//             @RequestParam(value = "signupSuccess", required = false) String signupSuccess,
//             Model m) {
//         if (error != null) {
//             m.addAttribute("loginError", "Invalid username or password.");
//         }
//         if (signupSuccess != null) {
//             m.addAttribute("signupSuccess", "Registration successful! Please sign in.");
//         }
//         return "login";
//     }
// }
package com.example.fitnesspoint.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fitnesspoint.model.User;
import com.example.fitnesspoint.repository.UserRepository;
import com.example.fitnesspoint.security.JwtUtil;

@Controller
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    // JWT login endpoint
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String username = loginRequest.get("username");
            String password = loginRequest.get("password");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            String jwt = jwtUtil.generateToken(userDetails);
            Map<String, String> response = new java.util.HashMap<>();
            response.put("token", jwt);
            return response;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signup")
    public String signupForm(Model m) {
        m.addAttribute("user", new User());
        // login.html contains both sign-in and sign-up panels
        return "login";
    }

    // Handle regular form submit (application/x-www-form-urlencoded)
    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String signupSubmit(@RequestParam String username, @RequestParam String password, Model m) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            m.addAttribute("signupError", "Please provide username and password.");
            return "login";
        }

        if (userRepo.findByUsername(username).isPresent()) {
            m.addAttribute("signupError", "Username already exists.");
            return "login";
        }

        try {
            User u = new User();
            u.setUsername(username);
            u.setPassword(passwordEncoder.encode(password));
            u.setRole("ROLE_USER");
            userRepo.save(u);
        } catch (DataIntegrityViolationException ex) {
            m.addAttribute("signupError", "Username already exists.");
            return "login";
        } catch (Exception ex) {
            m.addAttribute("signupError", "An error occurred. Please try again.");
            return "login";
        }

        return "redirect:/login?signupSuccess=true";
    }

    // Accept JSON signup from AJAX
    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signupJson(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Please provide username and password."));
        }

        if (userRepo.findByUsername(username).isPresent()) {
            return ResponseEntity.status(409).body(Map.of("message", "Username already exists."));
        }

        try {
            User u = new User();
            u.setUsername(username);
            u.setPassword(passwordEncoder.encode(password));
            u.setRole("ROLE_USER");
            userRepo.save(u);
            return ResponseEntity.ok(Map.of("message", "Registration successful"));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(Map.of("message", "An error occurred"));
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "signupSuccess", required = false) String signupSuccess,
            Model m) {
        if (error != null) {
            m.addAttribute("loginError", "Invalid username or password.");
        }
        if (signupSuccess != null) {
            m.addAttribute("signupSuccess", "Registration successful! Please sign in.");
        }
        return "login";
    }
}

package com.clashmate.backend.controllers;

import com.clashmate.backend.dto.JwtAuthenticationResponse;
import com.clashmate.backend.dto.LoginDTO;
import com.clashmate.backend.dto.api.ApiResponse;
import com.clashmate.backend.dto.auth.SignupDTO;
import com.clashmate.backend.repository.RoleRepository;
import com.clashmate.backend.repository.UserRepository;
import com.clashmate.backend.repository.UserRoleRepository;
import com.clashmate.backend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserRoleRepository userRoleRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmailAddress(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwtToken));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDTO signupDTO) {
//        if (userRepository.existsByEmailAddress(signupDTO.getEmailAddress())) {
//            return new ResponseEntity<Object>(new ApiResponse(Boolean.FALSE, "Email Address is already taken!"), HttpStatus.BAD_REQUEST);
//        }
//
//        if (userRepository.existsByPhoneNumber(signupDTO.getPhoneNumber())) {
//            return new ResponseEntity<Object>(new ApiResponse(Boolean.FALSE, "Phone Number is already taken!"), HttpStatus.BAD_REQUEST);
//        }
//
//        User user = new User(signupDTO);
//        user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
//        userRepository.save(user);
//
////        Role adminRole = roleRepository.findByName("ROLE_ADMIN").get();
//        Role userRole = roleRepository.findByName("ROLE_USER").get();
//
////        userRoleRepository.save(new UserRole(user, adminRole));
//        userRoleRepository.save(new UserRole(user, userRole));

        return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "User has registered successfully!"));
    }

}

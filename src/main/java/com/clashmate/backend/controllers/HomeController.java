package com.clashmate.backend.controllers;

import com.clashmate.backend.dto.UserProfile;
import com.clashmate.backend.security.CurrentUser;
import com.clashmate.backend.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Secured("ROLE_ADMIN")
    @PostMapping("/profile")
    public ResponseEntity<?> userProfile(@CurrentUser UserPrincipal userPrincipal) {
        System.out.println("First Name  ===>>>      " + userPrincipal.getId());
        return ResponseEntity.ok(new UserProfile());
    }

}

package com.jwtuserauthentication.controller;

import com.jwtuserauthentication.entity.User;
import com.jwtuserauthentication.helper.Response;
import com.jwtuserauthentication.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class Home {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody User UserCredential) throws Exception {
        return this.customUserDetailsService.generateToken(UserCredential);
    }
    @PostMapping("/adduser")
    public Response signupUser(@RequestBody User user) throws Exception {
        return this.customUserDetailsService.signupUser(user);
    }
}

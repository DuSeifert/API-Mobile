package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class LoginController {


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){

        if(request.getEmail().equals("usuario@esoft.com") && request.getPassword().equals("Abc123")){
            String token = UUID.randomUUID().toString();

            return ResponseEntity.ok(
                    new LoginResponse(token)
            );
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Email ou senha inválidos");
    }

}

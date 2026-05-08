package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepository repository;

    @GetMapping
    public Long Logar(@RequestBody Login login){
        /*
        return repository.equals(Login login)
        if (login.getEmail().equals("usuario@esoft.com") && login.getPassword().equals("Abc123")){
            return login.getUUID();
        }

         */

        return;
    }

}

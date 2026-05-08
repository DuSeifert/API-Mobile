package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = 'logins')
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long UUID;
    private Long email;
    private Long password;
}

package com.tmane.springbootmvcdemo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}

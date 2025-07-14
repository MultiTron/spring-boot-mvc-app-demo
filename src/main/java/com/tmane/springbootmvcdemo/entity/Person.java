package com.tmane.springbootmvcdemo.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected LocalDate dateOfBirth;
}

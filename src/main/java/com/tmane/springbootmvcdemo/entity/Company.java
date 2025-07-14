package com.tmane.springbootmvcdemo.entity;

import com.tmane.springbootmvcdemo.enums.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String country;
    @OneToOne(mappedBy = "company")
    private Ceo ceo;
    private LocalDate foundationDate;
    private BigDecimal revenue;
    @Enumerated(EnumType.STRING)
    private Sector sector;
}
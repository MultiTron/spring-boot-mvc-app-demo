package com.tmane.springbootmvcdemo.dto;

import com.tmane.springbootmvcdemo.enums.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    private UUID id;
    private String name;
    private String country;
    private String CEO;
    private LocalDate foundationDate;
    private Long revenue;
    @Enumerated(EnumType.STRING)
    private Sector sector;
}

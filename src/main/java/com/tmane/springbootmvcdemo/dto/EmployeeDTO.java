package com.tmane.springbootmvcdemo.dto;

import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO extends PersonDTO {
    private CeoDTO employer;
    private double salary;
}

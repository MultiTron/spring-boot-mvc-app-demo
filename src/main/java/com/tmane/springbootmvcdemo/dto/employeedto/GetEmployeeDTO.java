package com.tmane.springbootmvcdemo.dto.employeedto;

import com.tmane.springbootmvcdemo.util.annotations.PhoneNumber;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeDTO extends EmployeeDTO {
    @NotNull
    protected UUID id;
    @NotBlank
    protected String firstName;
    @NotBlank
    protected String lastName;
    @PhoneNumber
    protected String phoneNumber;
    @PastOrPresent
    protected LocalDate dateOfBirth;
    @NotNull
    private UUID employer;
    @DecimalMin("100.5")
    private BigDecimal salary;
}

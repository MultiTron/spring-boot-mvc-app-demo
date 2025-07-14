package com.tmane.springbootmvcdemo.dto.ceodto;


import com.tmane.springbootmvcdemo.util.annotations.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCeoDTO extends CeoDTO {
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
    private UUID company;
}

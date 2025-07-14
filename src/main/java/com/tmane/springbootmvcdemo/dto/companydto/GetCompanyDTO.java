package com.tmane.springbootmvcdemo.dto.companydto;

import com.tmane.springbootmvcdemo.dto.ceodto.GetCeoDTO;
import com.tmane.springbootmvcdemo.enums.Sector;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
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
public class GetCompanyDTO extends CompanyDTO {
    @NotNull
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String country;
    @Valid
    private GetCeoDTO ceo;
    @PastOrPresent
    private LocalDate foundationDate;
    @DecimalMin("10000")
    private BigDecimal revenue;
    @Enumerated(EnumType.STRING)
    private Sector sector;
}

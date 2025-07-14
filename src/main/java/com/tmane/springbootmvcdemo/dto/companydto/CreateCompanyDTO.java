package com.tmane.springbootmvcdemo.dto.companydto;

import com.tmane.springbootmvcdemo.enums.Sector;
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
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyDTO extends CompanyDTO {
    private String name;
    private String country;
    private UUID ceo;
    private LocalDate foundationDate;
    private BigDecimal revenue;
    private Sector sector;
}

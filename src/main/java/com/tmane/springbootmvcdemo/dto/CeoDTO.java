package com.tmane.springbootmvcdemo.dto;


import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CeoDTO extends PersonDTO{
    private CompanyDTO company;
}

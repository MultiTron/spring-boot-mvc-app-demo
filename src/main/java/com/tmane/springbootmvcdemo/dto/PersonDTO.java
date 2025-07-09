package com.tmane.springbootmvcdemo.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "type"
//)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = EmployeeDTO.class, name = "employee"),
//        @JsonSubTypes.Type(value = CeoDTO.class, name = "ceo")
//})
public abstract class PersonDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}

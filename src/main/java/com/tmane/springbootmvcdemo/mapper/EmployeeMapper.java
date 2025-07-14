package com.tmane.springbootmvcdemo.mapper;

import com.tmane.springbootmvcdemo.dto.employeedto.GetEmployeeDTO;
import com.tmane.springbootmvcdemo.entity.Ceo;
import com.tmane.springbootmvcdemo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    GetEmployeeDTO toDto(Employee employee);

    Employee toEntity(GetEmployeeDTO getEmployeeDTO);

    @Mapping(target = "employer", source = "ceo")
    Employee toEntity(GetEmployeeDTO getEmployeeDTO, Ceo ceo);
}

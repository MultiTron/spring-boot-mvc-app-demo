package com.tmane.springbootmvcdemo.mapper;

import com.tmane.springbootmvcdemo.dto.EmployeeDTO;
import com.tmane.springbootmvcdemo.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

@Component
public class EmployeeMapper{
    ModelMapper modelMapper = new ModelMapper();

    public EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
}

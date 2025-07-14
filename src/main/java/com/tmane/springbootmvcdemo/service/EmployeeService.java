package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.employeedto.EmployeeDTO;
import com.tmane.springbootmvcdemo.entity.Employee;

import java.util.UUID;

public interface EmployeeService extends BaseService<Employee, EmployeeDTO, UUID> {

}

package com.tmane.springbootmvcdemo.repository;

import com.tmane.springbootmvcdemo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, UUID> {

}

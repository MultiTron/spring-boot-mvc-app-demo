package com.tmane.springbootmvcdemo.repository;

import com.tmane.springbootmvcdemo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, UUID> {

    Page<Employee> findByFirstName(String firstName, Pageable pageable);
}

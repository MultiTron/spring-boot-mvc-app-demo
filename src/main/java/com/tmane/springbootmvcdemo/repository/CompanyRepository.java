package com.tmane.springbootmvcdemo.repository;

import com.tmane.springbootmvcdemo.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends BaseRepository<Company, UUID> {

    Page<Company> findByName(String name, Pageable pageable);
}

package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import com.tmane.springbootmvcdemo.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface CompanyService extends BaseService<CompanyDTO, UUID>{
//    Page<CompanyDTO> findPaginatedCompanies(int pageNum, int pageSize);
//
//    Page<CompanyDTO> findPaginatedCompaniesByName(String name, Pageable pageable);
//
//    CompanyDTO findCompanyById(Long id) throws CompanyNoSuchElementException;
//
//    void saveCompany(CompanyDTO companyDTO);
//
//    void deleteCompanyById(Long id);
}

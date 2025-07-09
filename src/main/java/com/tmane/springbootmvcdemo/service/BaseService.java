package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface BaseService<ENT, DTO, ID> {
    Page<DTO> findPaginated(int pageNum, int pageSize);

    Page<DTO> findPaginatedByName(String name, Pageable pageable);

    Optional<DTO> findById(ID id) throws CompanyNoSuchElementException;

    void save(DTO dto);

    void deleteById(ID id);
}

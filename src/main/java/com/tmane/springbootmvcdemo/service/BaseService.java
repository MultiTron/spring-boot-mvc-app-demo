package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface BaseService<T, ID> {
    Page<T> findPaginated(int pageNum, int pageSize);

    Page<T> findPaginatedByName(String name, Pageable pageable);

    Optional<T> findById(ID id) throws CompanyNoSuchElementException;

    void save(T dto);

    void deleteById(ID id);
}

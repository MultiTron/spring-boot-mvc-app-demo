package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.BaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface BaseService<ENT, DTO extends BaseDTO, ID> {
    Page<DTO> findPaginated(int pageNum, int pageSize);

    Page<DTO> findPaginatedByName(String name, Pageable pageable);

    Optional<DTO> findById(ID id) throws NoSuchElementException;

    void save(DTO dto);

    void deleteById(ID id);
}

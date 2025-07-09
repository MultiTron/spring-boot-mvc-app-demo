package com.tmane.springbootmvcdemo.service.Impl;

import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import com.tmane.springbootmvcdemo.repository.BaseRepository;
import com.tmane.springbootmvcdemo.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {
    private final BaseRepository<T, ID> repo;
    public BaseServiceImpl(BaseRepository<T, ID> repo) {
        this.repo = repo;
    }

    @Override
    public Page<T> findPaginated(int pageNum, int pageSize) {
        return repo.findAll(PageRequest.of(pageNum, pageSize));
    }

    @Override
    public Page<T> findPaginatedByName(String name, Pageable pageable) {
        return repo.findByName(name, pageable);
    }

    @Override
    public Optional<T> findById(ID id) throws CompanyNoSuchElementException {
        return repo.findById(id);
    }

    @Override
    public void save(T dto) {

    }

    @Override
    public void deleteById(ID id) {

    }
}

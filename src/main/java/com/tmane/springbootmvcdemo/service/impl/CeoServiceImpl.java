package com.tmane.springbootmvcdemo.service.impl;

import com.tmane.springbootmvcdemo.dto.ceodto.GetCeoDTO;
import com.tmane.springbootmvcdemo.entity.Ceo;
import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import com.tmane.springbootmvcdemo.mapper.CeoMapper;
import com.tmane.springbootmvcdemo.repository.CeoRepository;
import com.tmane.springbootmvcdemo.service.CeoService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CeoServiceImpl implements CeoService {
    private CeoRepository repository;
    private CeoMapper mapper;
    private MessageSource messageSource;

    public void getByCompany() {

    }

    @Override
    public Page<GetCeoDTO> findPaginated(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Ceo> page = repository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    @Override
    public Page<GetCeoDTO> findPaginatedByName(String name, Pageable pageable) {
        Page<Ceo> page = repository.findByFirstName(name, pageable);
        return page.map(mapper::toDto);
    }

    @Override
    public Optional<GetCeoDTO> findById(UUID id) throws CompanyNoSuchElementException {
        try {
            Ceo ceo = repository.findById(id).get();
            return Optional.ofNullable(mapper.toDto(ceo));
        } catch (NoSuchElementException exception) {
            String message = messageSource.getMessage("entity.notfound", new Object[]{id}, Locale.getDefault());
            throw new CompanyNoSuchElementException(message, id);
        }
    }

    @Override
    public void save(GetCeoDTO getCeoDTO) {
        Ceo ceo = mapper.toEntity(getCeoDTO);

        repository.save(ceo);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}

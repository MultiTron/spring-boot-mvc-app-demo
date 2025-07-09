package com.tmane.springbootmvcdemo.service.Impl;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import com.tmane.springbootmvcdemo.mapper.CompanyMapper;
import com.tmane.springbootmvcdemo.repository.CompanyRepository;
import com.tmane.springbootmvcdemo.service.CompanyService;
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
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository repository;
    private CompanyMapper mapper;
    private MessageSource messageSource;


    @Override
    public Page<CompanyDTO> findPaginated(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Company> page = repository.findAll(pageable);
        return page.map(mapper::mapToCompanyDTO);
    }

    @Override
    public Page<CompanyDTO> findPaginatedByName(String name, Pageable pageable) {

        Page<Company> page = repository.findByName(name, pageable);
        return page.map(mapper::mapToCompanyDTO);
    }

    @Override
    public Optional<CompanyDTO> findById(UUID id) {
        try {
            Company company = repository.findById(id).get();
            return Optional.ofNullable(mapper.mapToCompanyDTO(company));
        } catch (NoSuchElementException exception) {
            String message = messageSource.getMessage("entity.notfound", new Object[]{id}, Locale.getDefault());
            throw new CompanyNoSuchElementException(message, id);
        }
    }

    public void save(CompanyDTO companyDTO) {
        Company company = mapper.mapToCompany(companyDTO);

        repository.save(company);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}

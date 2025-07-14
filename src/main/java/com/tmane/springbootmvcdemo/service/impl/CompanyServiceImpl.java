package com.tmane.springbootmvcdemo.service.impl;

import com.tmane.springbootmvcdemo.dto.companydto.CompanyDTO;
import com.tmane.springbootmvcdemo.dto.companydto.CreateCompanyDTO;
import com.tmane.springbootmvcdemo.dto.companydto.GetCompanyDTO;
import com.tmane.springbootmvcdemo.entity.Ceo;
import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.exception.CeoNoSuchElementException;
import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import com.tmane.springbootmvcdemo.mapper.CompanyMapper;
import com.tmane.springbootmvcdemo.repository.CeoRepository;
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
    private CeoRepository ceoRepository;
    private CompanyMapper mapper;
    private MessageSource messageSource;


    @Override
    public Page<GetCompanyDTO> findPaginated(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Company> page = repository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    @Override
    public Page<GetCompanyDTO> findPaginatedByName(String name, Pageable pageable) {

        Page<Company> page = repository.findByName(name, pageable);
        return page.map(mapper::toDto);
    }

    @Override
    public Optional<GetCompanyDTO> findById(UUID id) {
        try {
            Company company = repository.findById(id).get();
            return Optional.ofNullable(mapper.toDto(company));
        } catch (NoSuchElementException exception) {
            String message = messageSource.getMessage("entity.notfound", new Object[]{id}, Locale.getDefault());
            throw new CompanyNoSuchElementException(message, id);
        }
    }

    @Override
    public void save(CompanyDTO dto) {

    }

    public void save(CreateCompanyDTO companyDTO) {
        UUID ceoId = companyDTO.getCeo();
        Optional<Ceo> ceo = ceoRepository.findById(ceoId);
        Company company;
        if (ceo.isPresent()) {
            company = mapper.toEntity(companyDTO, ceo.get());
        } else {
            String message = messageSource.getMessage("entity.notfound", new Object[]{ceoId}, Locale.getDefault());
            throw new CeoNoSuchElementException(message, ceoId);
        }


        repository.save(company);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}

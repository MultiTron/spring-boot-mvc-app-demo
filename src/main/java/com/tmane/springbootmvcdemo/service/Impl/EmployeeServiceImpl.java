package com.tmane.springbootmvcdemo.service.Impl;

import com.tmane.springbootmvcdemo.dto.EmployeeDTO;
import com.tmane.springbootmvcdemo.entity.Employee;
import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import com.tmane.springbootmvcdemo.mapper.EmployeeMapper;
import com.tmane.springbootmvcdemo.repository.EmployeeRepository;
import com.tmane.springbootmvcdemo.service.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;
    private EmployeeMapper mapper;
    private MessageSource messageSource;


    @Override
    public Page<EmployeeDTO> findPaginated(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        Page<Employee> page = repository.findAll(pageable);
        return page.map(mapper::mapToEmployeeDTO);
    }

    @Override
    public Page<EmployeeDTO> findPaginatedByName(String name, Pageable pageable) {
        Page<Employee> page = repository.findByName(name, pageable);
        return page.map(mapper::mapToEmployeeDTO);
    }

    @Override
    public Optional<EmployeeDTO> findById(UUID id) throws CompanyNoSuchElementException {
        try {
            Employee employee = repository.findById(id).get();
            return Optional.ofNullable(mapper.mapToEmployeeDTO(employee));
        } catch (NoSuchElementException exception) {
            String message = messageSource.getMessage("entity.notfound", new Object[]{id}, Locale.getDefault());
            throw new CompanyNoSuchElementException(message, id);
        }
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        Employee employee = mapper.mapToEmployee(employeeDTO);

        repository.save(employee);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}

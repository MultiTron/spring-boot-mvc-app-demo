package com.tmane.springbootmvcdemo.mapper;

import com.tmane.springbootmvcdemo.dto.companydto.CreateCompanyDTO;
import com.tmane.springbootmvcdemo.dto.companydto.GetCompanyDTO;
import com.tmane.springbootmvcdemo.entity.Ceo;
import com.tmane.springbootmvcdemo.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    GetCompanyDTO toDto(Company company);

    Company toEntity(GetCompanyDTO getCompanyDTO);

    @Mapping(target = "ceo", source = "ceo")
    Company toEntity(CreateCompanyDTO companyDTO, Ceo ceo);
}

package com.tmane.springbootmvcdemo.mapper;

import com.tmane.springbootmvcdemo.dto.ceodto.GetCeoDTO;
import com.tmane.springbootmvcdemo.entity.Ceo;
import com.tmane.springbootmvcdemo.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CeoMapper {

    GetCeoDTO toDto(Ceo ceo);

    @Mapping(target = "company", source = "company")
    GetCeoDTO toDto(Ceo ceo, Company company);

    Ceo toEntity(GetCeoDTO getCeoDTO);
}

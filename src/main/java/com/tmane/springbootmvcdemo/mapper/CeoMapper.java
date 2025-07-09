package com.tmane.springbootmvcdemo.mapper;

import com.tmane.springbootmvcdemo.dto.CeoDTO;
import com.tmane.springbootmvcdemo.entity.Ceo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CeoMapper {
    ModelMapper mapper = new ModelMapper();

    public CeoDTO mapToCeoDTO(Ceo ceo) {
        return mapper.map(ceo, CeoDTO.class);
    }

    public Ceo mapToCeo(CeoDTO ceoDTO) {
        return mapper.map(ceoDTO, Ceo.class);
    }
}

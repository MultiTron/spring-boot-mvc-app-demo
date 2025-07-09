package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.CeoDTO;
import com.tmane.springbootmvcdemo.entity.Ceo;

import java.util.UUID;

public interface CeoService extends BaseService<Ceo, CeoDTO, UUID> {
}

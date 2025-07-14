package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.companydto.CompanyDTO;
import com.tmane.springbootmvcdemo.entity.Company;

import java.util.UUID;


public interface CompanyService extends BaseService<Company, CompanyDTO, UUID> {

}

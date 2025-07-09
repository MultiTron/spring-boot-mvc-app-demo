package com.tmane.springbootmvcdemo;

import com.tmane.springbootmvcdemo.repository.CompanyRepository;
import com.tmane.springbootmvcdemo.repository.Impl.CompanyRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CompanyRepository companyRepository() {
        return new CompanyRepositoryImpl();
    }
}

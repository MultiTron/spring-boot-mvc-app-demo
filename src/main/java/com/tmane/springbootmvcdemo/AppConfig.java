package com.tmane.springbootmvcdemo;

import com.tmane.springbootmvcdemo.entity.Ceo;
import com.tmane.springbootmvcdemo.entity.Employee;
import com.tmane.springbootmvcdemo.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("ceo")
    public Person getCeo() {
        return new Ceo();
    }

    @Bean
    @Qualifier("employee")
    public Person getEmployee(){
        return new Employee();
    }
}

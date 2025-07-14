package com.tmane.springbootmvcdemo.controller;


import com.tmane.springbootmvcdemo.dto.employeedto.GetEmployeeDTO;
import com.tmane.springbootmvcdemo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.tmane.springbootmvcdemo.util.Constants.PAGE_SIZE;

@AllArgsConstructor
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;


    @GetMapping("page/{pageNum}")
    public Page<GetEmployeeDTO> getPaginatedEmployees(@PathVariable(value = "pageNum") int pageNum, @RequestParam(name = "keyword", required = false) String keyword) {
        Page<GetEmployeeDTO> page;

        if (keyword != null && !keyword.trim().isEmpty() && !"null".equalsIgnoreCase(keyword)) {
            page = service.findPaginatedByName((keyword), PageRequest.of(pageNum - 1, PAGE_SIZE));
        } else {
            page = service.findPaginated(pageNum, PAGE_SIZE);
        }
        return page;
    }
}

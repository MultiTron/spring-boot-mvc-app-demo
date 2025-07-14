package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.dto.ceodto.GetCeoDTO;
import com.tmane.springbootmvcdemo.service.CeoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.tmane.springbootmvcdemo.util.Constants.PAGE_SIZE;

@AllArgsConstructor
@RestController
@RequestMapping("/ceos")
public class CeoController {
    private final CeoService service;

    @GetMapping("page/{pageNum}")
    public Page<GetCeoDTO> getPaginatedCeos(@PathVariable(value = "pageNum") int pageNum, @RequestParam(name = "keyword") String keyword) {
        Page<GetCeoDTO> page;

        if (keyword != null && !keyword.trim().isEmpty() && !"null".equalsIgnoreCase(keyword)) {
            page = service.findPaginatedByName((keyword), PageRequest.of(pageNum - 1, PAGE_SIZE));
        } else {
            page = service.findPaginated(pageNum, PAGE_SIZE);
        }
        return page;
    }

    @PostMapping("add/")
    public ResponseEntity<GetCeoDTO> addCeo(@RequestBody @Validated GetCeoDTO ceo) {
        service.save(ceo);
        return ResponseEntity.ok(ceo);
    }

}

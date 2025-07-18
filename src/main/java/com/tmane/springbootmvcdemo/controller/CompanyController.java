package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.dto.companydto.GetCompanyDTO;
import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.enums.Sector;
import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

import static com.tmane.springbootmvcdemo.util.Constants.ADD_COMPANY_PAGE;
import static com.tmane.springbootmvcdemo.util.Constants.COMPANIES_PAGE;
import static com.tmane.springbootmvcdemo.util.Constants.COMPANIES_REDIRECT;
import static com.tmane.springbootmvcdemo.util.Constants.EDIT_COMPANY_PAGE;
import static com.tmane.springbootmvcdemo.util.Constants.PAGE_NUMBER;
import static com.tmane.springbootmvcdemo.util.Constants.PAGE_SIZE;
import static com.tmane.springbootmvcdemo.util.Constants.VIEW_COMPANY_PAGE;

@AllArgsConstructor
@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;


    public int retrieveLastPageNumber() {
        Page<GetCompanyDTO> page = companyService.findPaginated(PAGE_NUMBER, PAGE_SIZE);

        return page.getTotalPages();
    }

    @GetMapping
    public String displayHomePage(Model model,
                                  @RequestParam(value = "keyword", required = false) String keyword) {
        return displayPaginatedCompanies(model, PAGE_NUMBER, keyword);
    }

    @GetMapping("/page/{pageNum}")
    public String displayPaginatedCompanies(Model model,
                                            @PathVariable(value = "pageNum") int pageNum,
                                            @RequestParam(name = "keyword", required = false) String keyword) {

        Page<GetCompanyDTO> page;

        if (keyword != null && !keyword.trim().isEmpty() && !"null".equalsIgnoreCase(keyword)) {
            page = companyService.findPaginatedByName((keyword), PageRequest.of(pageNum - 1, PAGE_SIZE));
        } else {
            page = companyService.findPaginated(pageNum, PAGE_SIZE);
        }

        List<GetCompanyDTO> companyList = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("companyList", companyList);
        model.addAttribute("keyword", keyword);

        return COMPANIES_PAGE;
    }

    @GetMapping("/{id}")
    public String displayCompanyDetails(@PathVariable UUID id, Model model) {
        model.addAttribute("company", companyService.findById(id));

        return VIEW_COMPANY_PAGE;
    }

    @GetMapping("/new")
    public String displayAddCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("sectors", Sector.values());

        return ADD_COMPANY_PAGE;
    }

    @PostMapping
    public String saveCompany(@ModelAttribute("company") GetCompanyDTO getCompanyDTO) {
        if (getCompanyDTO.getSector() == null || getCompanyDTO.getSector().toString().isEmpty()) {
            getCompanyDTO.setSector(Sector.DFAULT_SECTOR);
        }
        companyService.save(getCompanyDTO);

        return "redirect:" + COMPANIES_REDIRECT + "/page/" + retrieveLastPageNumber();
    }

    @GetMapping("/{id}/edit")
    public String displayEditCompanyForm(@PathVariable UUID id, Model model,
                                         @RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "page", defaultValue = "1") int page) {
        GetCompanyDTO getCompanyDTO = companyService.findById(id).get();
        model.addAttribute("company", getCompanyDTO);
        model.addAttribute("sectors", Sector.values());
        model.addAttribute("page", page);
        model.addAttribute(("keyword"), keyword);

        return EDIT_COMPANY_PAGE;
    }

    @PostMapping("/{id}/update")
    public String updateCompany(@ModelAttribute("company") GetCompanyDTO getCompanyDTO,
                                @PathVariable UUID id,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(defaultValue = "1") int page) {
        companyService.save(getCompanyDTO);

        return "redirect:" + COMPANIES_REDIRECT + "/page/" + page + "?keyword=" + (keyword == null ? "" : keyword);
    }

    @GetMapping("/{id}/delete")
    public String deleteCompany(@PathVariable UUID id,
                                @RequestParam(name = "page", defaultValue = "0") int page) {
        companyService.deleteById(id);

        return "redirect:" + COMPANIES_REDIRECT + "?page=" + page;
    }
}

package com.example.demo.Controller;


import com.example.demo.DTO.CompanyDTO;
import com.example.demo.DTO.SplitDTO;
import com.example.demo.Model.BusinessOwner;
import com.example.demo.Model.Company;
import com.example.demo.Persistence.API.RepositoryFactory;
import com.example.demo.Service.BusinessOwnerService;
import com.example.demo.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final BusinessOwnerService businessOwnerService;

    @GetMapping("/all-company")
    public List<Company> getAllCompanies()
    {
        return companyService.findAll();
    }

    @PostMapping("/add-company")
    public void addCompany(@RequestBody CompanyDTO companyDTO) throws Exception
    {
        BusinessOwner owner = businessOwnerService.findOwnerByUsername(companyDTO.getOwner()).orElseThrow(() -> new Exception("No owner found"));
        companyService.createCompany(owner.getUsername(), companyDTO.getName(), companyDTO.getTag(), companyDTO.getEvaluation(), companyDTO.getSharePrice());
    }

    @GetMapping("/companies/{username}")
    public List<Company> getCompaniesOfUser(@PathVariable String username) throws Exception
    {
        BusinessOwner businessOwner = businessOwnerService.findOwnerByUsername(username).orElseThrow(() -> new Exception("No owner found"));
        return companyService.findAll().stream().filter(company -> company.getOwnerId() == businessOwner.getId()).collect(Collectors.toList());
    }

    @PostMapping("/split")
    public void split(@RequestBody SplitDTO splitDTO) throws Exception
    {
        if(companyService.findByName(splitDTO.getCompany()).isPresent() && businessOwnerService.findOwnerByUsername(splitDTO.getUsername()).isPresent() && companyService.findByName(splitDTO.getCompany()).get().getOwnerId() == businessOwnerService.findOwnerByUsername(splitDTO.getUsername()).get().getId())
        {
            businessOwnerService.performSplit(splitDTO.getSplit(), splitDTO.getCompany());
        }
    }
}

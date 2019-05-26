package com.example.demo.Service;


import com.example.demo.Model.BusinessOwner;
import com.example.demo.Model.Company;
import com.example.demo.Persistence.API.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final RepositoryFactory repositoryFactory;

    public Optional<Company> findById(int id)
    {
        return repositoryFactory.createCompanyRepository().findById(id);
    }

    public Optional<Company> findByName(String name)
    {
        return repositoryFactory.createCompanyRepository().findByName(name);
    }

    public Optional<Company> findByTag(String tag)
    {
        return repositoryFactory.createCompanyRepository().findByTag(tag);
    }

    public List<Company> findAll()
    {
        return repositoryFactory.createCompanyRepository().findAll();
    }

    public Company createCompany(String owner, String name, String tag, int evaluation, int sharePrice) throws Exception
    {
        BusinessOwner businessOwner = repositoryFactory.createBusinessOwnerRepository().findByUsername(owner).orElseThrow(() -> new Exception("user not found"));
        Company company = new Company(businessOwner.getId(), name, tag, evaluation / sharePrice, sharePrice, "1-1");
        return repositoryFactory.createCompanyRepository().save(company);
    }


}

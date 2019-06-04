package com.example.demo.Persistence.API;

import com.example.demo.Model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {

    Company save(Company company);

    Optional<Company> findById(int id);

    Optional<Company> findByName(String name);

    Optional<Company> findByTag(String tag);

    List<Company> findAll();

}

package com.example.demo.Service;


import com.example.demo.Model.Company;
import com.example.demo.Model.Investor;
import com.example.demo.Model.Transaction;
import com.example.demo.Persistence.API.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvestorService {

    private final RepositoryFactory repositoryFactory;

    @Transactional
    public List<Investor> listAllInvestors()
    {
        return repositoryFactory.createInvestorRepository().findAll();
    }

    @Transactional
    public Optional<Investor> findById(int id)
    {
        return repositoryFactory.createInvestorRepository().findById(id);
    }

    @Transactional
    public Optional<Investor> findByUsername(String username)
    {
        return repositoryFactory.createInvestorRepository().findByUsername(username);
    }

    public Investor addInvestor(String username, String password)
    {
        Investor investor = new Investor(username, password, 10000);
        return repositoryFactory.createInvestorRepository().save(investor);
    }




}

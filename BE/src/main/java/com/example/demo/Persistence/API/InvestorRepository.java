package com.example.demo.Persistence.API;

import com.example.demo.Model.Investor;

import java.util.List;
import java.util.Optional;

public interface InvestorRepository {


    Investor save(Investor investor);

    Optional<Investor> findById(int id);

    Optional<Investor> findByUsername(String username);

    List<Investor> findAll();

}




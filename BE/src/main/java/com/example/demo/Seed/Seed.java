package com.example.demo.Seed;

import com.example.demo.Model.BusinessOwner;
import com.example.demo.Model.Company;
import com.example.demo.Model.Investor;
import com.example.demo.Model.Transaction;
import com.example.demo.Persistence.API.*;

import com.example.demo.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import java.util.Date;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Seed implements CommandLineRunner
{
    private final RepositoryFactory factory;

    @Override
    @Transactional
    public void run(String... args) throws Exception
    {

    }
}

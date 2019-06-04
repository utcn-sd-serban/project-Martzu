package com.example.demo.Persistence.Jdbc;

import com.example.demo.Persistence.API.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "a1.repository-type", havingValue = "JDBC")
public class JdbcRepositoryFactory implements RepositoryFactory {

    private final JdbcTemplate template;

    @Override
    public BusinessOwnerRepository createBusinessOwnerRepository() {
        return new JdbcBusinessOwnerRepository(template);
    }

    @Override
    public CompanyRepository createCompanyRepository() {
        return new JdbcCompanyRepository(template);
    }

    @Override
    public InvestorRepository createInvestorRepository() {
        return new JdbcInvestorRepository(template);
    }

    @Override
    public TransactionRepository createTransactionRepository() {
        return new JdbcTransactionRepository(template);
    }

    @Override
    public OwnedStocksRepository createOwnedStockRepository() {
        return new JdbcOwnedStocksRepository(template);
    }
}

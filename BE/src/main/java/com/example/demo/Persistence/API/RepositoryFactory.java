package com.example.demo.Persistence.API;


public interface RepositoryFactory {


    BusinessOwnerRepository createBusinessOwnerRepository();

    CompanyRepository createCompanyRepository();

    InvestorRepository createInvestorRepository();

    TransactionRepository createTransactionRepository();

    OwnedStocksRepository createOwnedStockRepository();


}

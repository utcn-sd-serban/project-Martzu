package com.example.demo.Service;


import com.example.demo.Model.*;
import com.example.demo.Persistence.API.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final RepositoryFactory repositoryFactory;


    @Transactional
    public List<Transaction> listAllInvestorTransactions(String username) throws Exception
    {
        Investor investor = repositoryFactory.createInvestorRepository().findByUsername(username).orElseThrow(() -> new Exception("No investor found"));
        return repositoryFactory.createTransactionRepository().findAll().stream().filter(transaction -> transaction.getInvestorId() == investor.getId()).collect(Collectors.toList());
    }


    @Transactional
    public void placeTransaction(String username, String criteria, boolean byTag, int shares, boolean buying) throws Exception
    {
        Investor investor = repositoryFactory.createInvestorRepository().findByUsername(username).orElseThrow(() -> new Exception("No investor found"));
        Company company1;
        if(byTag)
        {
            company1 = repositoryFactory.createCompanyRepository().findByTag(criteria).orElseThrow(() -> new Exception("No company found"));
        }
        else
        {
            company1 = repositoryFactory.createCompanyRepository().findByName(criteria).orElseThrow(() -> new Exception("No company found"));
        }

        if(buying)
        {
            if(investor.getCapital() >= shares * company1.getSharePrice() && company1.getShares() > shares)
            {
                repositoryFactory.createTransactionRepository().save(new Transaction(investor.getId(), company1.getId(), "b", shares, company1.getSharePrice()));

                Optional<OwnedStocks> ownedStocks = repositoryFactory.createOwnedStockRepository().findOwnedStockByUsernameAndCompany(investor.getId(), company1.getId());

                if(!ownedStocks.isPresent())
                {
                    repositoryFactory.createOwnedStockRepository().save(new OwnedStocks(investor.getId(), company1.getId(), shares, company1.getSharePrice()));
                }
                else
                {
                    ownedStocks.get().setStockNumber(ownedStocks.get().getStockNumber() + shares);
                    ownedStocks.get().setStockPrice(company1.getSharePrice());
                    repositoryFactory.createOwnedStockRepository().save(ownedStocks.get());
                }
                investor.setCapital(investor.getCapital() - shares * company1.getSharePrice());
                company1.setShares(company1.getShares() - shares);
                company1.setSharePrice(company1.getSharePrice() + (double) shares / 10 * 0.15);



            }
        }
        else
        {
            Optional<OwnedStocks> ownedStocks = repositoryFactory.createOwnedStockRepository().findOwnedStockByUsernameAndCompany(investor.getId(), company1.getId());
            if(ownedStocks.isPresent() && ownedStocks.get().getStockNumber() >= shares)
            {
                repositoryFactory.createTransactionRepository().save(new Transaction(investor.getId(), company1.getId(), "s", shares, company1.getSharePrice()));

                OwnedStocks stocks = ownedStocks.get();
                stocks.setStockNumber(ownedStocks.get().getStockNumber() - shares);
                stocks.setStockPrice(company1.getSharePrice());

                investor.setCapital(investor.getCapital() + shares * company1.getSharePrice());
                company1.setShares(company1.getShares() + shares);
                company1.setSharePrice(company1.getSharePrice() - (double) shares / 10 * 0.1);



                repositoryFactory.createOwnedStockRepository().save(ownedStocks.get());
            }


        }

        repositoryFactory.createInvestorRepository().save(investor);
        repositoryFactory.createCompanyRepository().save(company1);
        updateSharePrice(company1);

    }

    private void updateSharePrice(Company company)
    {
        repositoryFactory.createOwnedStockRepository().findAllStocksOwnedAtACompany(company.getId()).forEach(ownedStocks -> {
            ownedStocks.setStockPrice(company.getSharePrice());
            repositoryFactory.createOwnedStockRepository().save(ownedStocks);
        });
    }

    @Transactional
    public void placeBuyTransactionByName(String username, String company, int shares) throws Exception
    {
        placeTransaction(username, company,  false, shares, true);
    }

    @Transactional
    public void placeSellTransactionByName(String username, String company, int shares) throws Exception
    {
        placeTransaction(username, company, false, shares, false);
    }

    @Transactional
    public void placeBuyTransactionByTag(String username, String tag, int shares) throws Exception
    {
        placeTransaction(username, tag,  true, shares, true);
    }

    @Transactional
    public void placeSellTransactionByTag(String username, String tag, int shares) throws Exception
    {
        placeTransaction(username, tag,  true, shares, false);
    }


}

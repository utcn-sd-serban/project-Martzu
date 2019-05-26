package com.example.demo;

import com.example.demo.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Controller implements CommandLineRunner {
    private final BusinessOwnerService businessOwnerService;
    private final TransactionService transactionService;
    private final CompanyService companyService;
    private final InvestorService investorService;
    private final OwnedStocksService ownedStocksService;

    @Override
    public void run(String... args) throws Exception {

        businessOwnerService.createOnwer("John", "Test");
        companyService.createCompany("John", "Petrom", "PT", 100000, 4);
        investorService.addInvestor("ME", "ME");
        transactionService.placeBuyTransactionByTag("ME", "PT", 30);
        transactionService.placeBuyTransactionByName("ME", "Petrom", 10);

        ownedStocksService.getOwnedStocksOfInvestor("ME").forEach(ownedStocks -> System.out.println(companyService.findById(ownedStocks.getCompanyId()) + " : " + ownedStocks.getStockNumber() + " " + ownedStocks.getStockPrice()));

        transactionService.listAllInvestorTransactions("ME").forEach(transaction -> System.out.println(transaction.toString()));

        businessOwnerService.performSplit("1-2", "Petrom");



        businessOwnerService.performSplit("4-3", "Petrom");


        transactionService.placeSellTransactionByName("ME","Petrom", 20);

        ownedStocksService.getOwnedStocksOfInvestor("ME").forEach(ownedStocks -> System.out.println(companyService.findById(ownedStocks.getCompanyId()) + " : " + ownedStocks.getStockNumber() + " " + ownedStocks.getStockPrice()));



    }
}

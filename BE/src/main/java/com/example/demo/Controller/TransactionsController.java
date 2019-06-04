package com.example.demo.Controller;


import com.example.demo.DTO.TransactionDTO;
import com.example.demo.Model.Company;
import com.example.demo.Model.Investor;
import com.example.demo.Model.Transaction;
import com.example.demo.Service.CompanyService;
import com.example.demo.Service.InvestorService;
import com.example.demo.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TransactionsController {


    private final TransactionService transactionService;
    private final CompanyService companyService;

    public void placeTransaction(String company, String username, int shareNumber, boolean byTag, boolean selling) throws Exception
    {
        if(selling)
        {
            if(byTag)
            {
                transactionService.placeSellTransactionByTag(username,company,shareNumber);
            }
            else
            {
                transactionService.placeSellTransactionByName(username,company,shareNumber);
            }
        }
        else
        {
            if(byTag)
            {
                transactionService.placeBuyTransactionByTag(username,company,shareNumber);
            }
            else
            {
                transactionService.placeBuyTransactionByName(username,company,shareNumber);
            }
        }
    }

    @GetMapping("/all-transactions/{username}")
    public List<TransactionDTO> getTransactionsOfUser(@PathVariable String username) throws Exception
    {
        List<TransactionDTO> transactionDTOList = new ArrayList<>();
        transactionService.listAllInvestorTransactions(username).forEach(transaction -> {
            Optional<Company> company = companyService.findById(transaction.getCompanyId());
            if(company.isPresent())
            {
                transactionDTOList.add(new TransactionDTO(username, company.get().getName(), transaction.getStockNumber(), transaction.getStockPrice(),transaction.getType(), transaction.getCreationDate().toString()));
            }
        });
        return transactionDTOList;
    }

    @PostMapping("/buy-transaction-name")
    public void buyTransactionName(@RequestBody TransactionDTO transactionDTO) throws Exception
    {
        placeTransaction(transactionDTO.getCompany(), transactionDTO.getUserName(), transactionDTO.getStockNumber(), false, false);
    }

    @PostMapping("/buy-transaction-tag")
    public void buyTransactionTag(@RequestBody TransactionDTO transactionDTO) throws Exception
    {
        placeTransaction(transactionDTO.getCompany(), transactionDTO.getUserName(), transactionDTO.getStockNumber(), true, false);
    }

    @PostMapping("/sell-transaction-name")
    public void sellTransactionName(@RequestBody TransactionDTO transactionDTO) throws Exception
    {
        placeTransaction(transactionDTO.getCompany(), transactionDTO.getUserName(), transactionDTO.getStockNumber(), false, true);
    }

    @PostMapping("/sell-transaction-tag")
    public void sellTransactionTag(@RequestBody TransactionDTO transactionDTO) throws Exception
    {
        placeTransaction(transactionDTO.getCompany(), transactionDTO.getUserName(), transactionDTO.getStockNumber(), true, true);
    }





}

package com.example.demo.Persistence.API;

import com.example.demo.Model.OwnedStocks;

import java.util.List;
import java.util.Optional;

public interface OwnedStocksRepository {

    public Optional<OwnedStocks> findById(int id);

    public List<OwnedStocks> findAll();

    public List<OwnedStocks> findAllStocksOwnedByInvestor(int investorId);

    public OwnedStocks save(OwnedStocks ownedStocks);

    public Optional<OwnedStocks> findOwnedStockByUsernameAndCompany(int investorId, int companyId);

    public List<OwnedStocks> findAllStocksOwnedAtACompany(int companyId);
}

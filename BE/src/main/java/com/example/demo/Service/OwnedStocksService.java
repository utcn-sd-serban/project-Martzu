package com.example.demo.Service;


import com.example.demo.Model.Investor;
import com.example.demo.Model.OwnedStocks;
import com.example.demo.Persistence.API.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnedStocksService {
    private final RepositoryFactory repositoryFactory;

    public List<OwnedStocks> getOwnedStocksOfInvestor(String username) throws Exception
    {
        Investor investor = repositoryFactory.createInvestorRepository().findByUsername(username).orElseThrow(() -> new Exception("No investor found"));
        return repositoryFactory.createOwnedStockRepository().findAllStocksOwnedByInvestor(investor.getId());
    }
}

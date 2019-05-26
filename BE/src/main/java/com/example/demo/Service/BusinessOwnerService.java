package com.example.demo.Service;


import com.example.demo.Model.BusinessOwner;
import com.example.demo.Model.Company;
import com.example.demo.Persistence.API.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessOwnerService {

    private final RepositoryFactory repositoryFactory;

    public BusinessOwner createOnwer(String username, String password)
    {
        BusinessOwner businessOwner = new BusinessOwner(username, password);
        return repositoryFactory.createBusinessOwnerRepository().save(businessOwner);
    }

    public void performSplit(String split, String company) throws Exception
    {
        final int n = Integer.parseInt(split.split("-")[0]);
        final int m = Integer.parseInt(split.split("-")[1]);

        Company company1 = repositoryFactory.createCompanyRepository().findByName(company).orElseThrow(() -> new Exception("No company found"));

        int oldShareNumber = company1.getShares();
        double oldSharePrice = company1.getSharePrice();

        int newShareNumber = (oldShareNumber / n) * m;
        double newSharePrice = (oldShareNumber * oldSharePrice) / newShareNumber;

        company1.setShares(newShareNumber);
        company1.setSharePrice(newSharePrice);

        updateStocks(n, m, company1.getId());

        repositoryFactory.createCompanyRepository().save(company1);
    }

    private void updateStocks(final int n, final int m, int companyId)
    {
        repositoryFactory.createOwnedStockRepository().findAllStocksOwnedAtACompany(companyId).forEach(ownedStocks -> {

            int shareNumber = ownedStocks.getStockNumber();
            int shareNumber1 = ownedStocks.getStockNumber();
            double sharePrice = ownedStocks.getStockPrice();

            shareNumber = (shareNumber / n) * m;
            sharePrice = (sharePrice * shareNumber1) / shareNumber;

            ownedStocks.setStockNumber(shareNumber);
            ownedStocks.setStockPrice(sharePrice);

            repositoryFactory.createOwnedStockRepository().save(ownedStocks);

        });

    }

}

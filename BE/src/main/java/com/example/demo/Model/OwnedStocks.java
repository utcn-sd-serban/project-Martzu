package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OwnedStocks {

    private int id = 0;
    private int investorId;
    private int companyId;
    private int stockNumber;
    private double stockPrice;

    public OwnedStocks(int investorId, int companyId, int stockNumber, double stockPrice)
    {
        this.investorId = investorId;
        this.companyId = companyId;
        this.stockNumber = stockNumber;
        this.stockPrice = stockPrice;
    }
}

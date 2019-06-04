package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private int id = 0;
    private int investorId;
    private int companyId;
    private String type;
    private int stockNumber;
    private double stockPrice;
    private Date creationDate;


    public Transaction(int investorId, int companyId, String type, int stockNumber, double stockPrice)
    {
        this.investorId = investorId;
        this.companyId = companyId;
        this.type = type;
        this.stockNumber = stockNumber;
        this.stockPrice = stockPrice;
        this.creationDate = new Date();
    }


}

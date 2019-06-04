package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private int id = 0;
    private int ownerId;
    private String name;
    private String tag;
    private int shares;
    private double sharePrice;
    private String splitFactor;

    public Company(int ownerId, String name, String tag, int shares, double sharePrice, String splitFactor)
    {
        this.ownerId = ownerId;
        this.name = name;
        this.tag = tag;
        this.shares = shares;
        this.sharePrice = sharePrice;
        this.splitFactor = splitFactor;
    }
}

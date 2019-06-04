package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Investor {

    private int id = 0;
    private String username;
    private String password;
    private double capital = 5000;

    /*
    public Investor(String username, String password, double capital)
    {
        this.username = username;
        this.password = password;
        this.capital = capital;
    }*/

    public Investor(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}

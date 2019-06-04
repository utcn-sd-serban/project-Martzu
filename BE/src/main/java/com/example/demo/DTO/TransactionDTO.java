package com.example.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private String userName;
    private String company;
    private int stockNumber;
    private double stockPrice;
    private String type;
    private String date;

}

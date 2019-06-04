package com.example.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnedStockDTO {

    private String company;
    private int shareNumber;
    private double sharePrice;


}

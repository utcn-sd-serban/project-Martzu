package com.example.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    private String owner;
    private String name;
    private String tag;
    private int evaluation;
    private int sharePrice;
    private String splitFactor;
}

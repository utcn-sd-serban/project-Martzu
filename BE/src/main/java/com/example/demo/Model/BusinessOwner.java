package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessOwner {


    private int id = 0;
    private String username;
    private String password;

    public BusinessOwner(String username, String password)
    {
        this.username = username;
        this.password = password;
    }



}

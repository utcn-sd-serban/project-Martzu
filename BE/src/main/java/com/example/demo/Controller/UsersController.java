package com.example.demo.Controller;


import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Model.BusinessOwner;
import com.example.demo.Model.Investor;
import com.example.demo.Service.BusinessOwnerService;
import com.example.demo.Service.InvestorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final InvestorService investorService;
    private final BusinessOwnerService businessOwnerService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login-investor")
    public void loginInvestor(@RequestBody Investor investor) throws Exception
    {
        Investor investor1 = investorService.findByUsername(investor.getUsername()).orElseThrow(() -> new Exception("No investor found"));

        if(!passwordEncoder.matches(investor.getPassword(), investor1.getPassword()))
        {
            throw new UserNotFoundException();
        }
    }


    @PostMapping("/login-owner")
    public void loginOwner(@RequestBody BusinessOwner businessOwner) throws Exception
    {
        BusinessOwner businessOwner1 = businessOwnerService.findOwnerByUsername(businessOwner.getUsername()).orElseThrow(() -> new Exception("No investor found"));

        if(!passwordEncoder.matches(businessOwner.getPassword(), businessOwner1.getPassword()))
        {
            throw new UserNotFoundException();
        }
    }

    @PostMapping("/create-investor")
    public Investor createInvestor(@RequestBody Investor investor) throws Exception
    {
        if(investorService.findByUsername(investor.getUsername()).isPresent())
        {
            throw new Exception("Investor already exists");
        }
        else
        {
            return investorService.addInvestor(investor.getUsername(), passwordEncoder.encode(investor.getPassword()));
        }
    }

    @PostMapping("/create-owner")
    public BusinessOwner createOwner(@RequestBody BusinessOwner businessOwner) throws Exception
    {
        if(businessOwnerService.findOwnerByUsername(businessOwner.getUsername()).isPresent())
        {
            throw new Exception("Owner already exists");
        }
        else
        {
            return businessOwnerService.createOwner(businessOwner.getUsername(), passwordEncoder.encode(businessOwner.getPassword()));
        }
    }

    @GetMapping("/get-investors")
    public List<Investor> getAllInvestors()
    {
        return investorService.listAllInvestors();
    }

    @GetMapping("/get-owners")
    public List<BusinessOwner> getAllOwners()
    {
        return businessOwnerService.findAllOwners();
    }


}

package com.example.demo.Controller;


import com.example.demo.DTO.OwnedStockDTO;
import com.example.demo.Service.CompanyService;
import com.example.demo.Service.OwnedStocksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OwnedStocksController {
    private final OwnedStocksService ownedStocksService;
    private final CompanyService companyService;

    @GetMapping("/owned-stocks/{username}")
    public List<OwnedStockDTO> getOwnedStocksOfUser(@PathVariable String username) throws Exception
    {
        List<OwnedStockDTO> ownedStockDTOList = new ArrayList<>();
        ownedStocksService.getOwnedStocksOfInvestor(username).forEach(ownedStocks ->{
            if(companyService.findById(ownedStocks.getCompanyId()).isPresent())
            {
                OwnedStockDTO ownedStockDTO = new OwnedStockDTO(companyService.findById(ownedStocks.getCompanyId()).get().getName(), ownedStocks.getStockNumber(), ownedStocks.getStockPrice());
                ownedStockDTOList.add(ownedStockDTO);
            }
        });
        return ownedStockDTOList;
    }
}

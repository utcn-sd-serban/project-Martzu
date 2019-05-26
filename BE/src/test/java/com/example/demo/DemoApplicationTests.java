package com.example.demo;

import com.example.demo.Model.BusinessOwner;
import com.example.demo.Model.Transaction;
import com.example.demo.Persistence.API.RepositoryFactory;
import com.example.demo.Persistence.Jdbc.JdbcRepositoryFactory;
import com.example.demo.Service.BusinessOwnerService;
import com.example.demo.Service.CompanyService;
import com.example.demo.Service.InvestorService;
import com.example.demo.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@RunWith(SpringRunner.class)
//@SpringBootTest

@RequiredArgsConstructor
public class DemoApplicationTests {


	@Test
	public void checkIfCapitalUpdated() {

	}

}
